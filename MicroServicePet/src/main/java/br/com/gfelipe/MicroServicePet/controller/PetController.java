package br.com.gfelipe.MicroServicePet.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.gfelipe.MicroServicePet.dto.PetRecordDto;
import br.com.gfelipe.MicroServicePet.models.PetModel;
import br.com.gfelipe.MicroServicePet.repositories.IPetRepository;
import br.com.gfelipe.MicroServicePet.service.IPetService;
import jakarta.validation.Valid;

@RestController
public class PetController {
	
	@Autowired
	IPetService service;
	@Autowired
	IPetRepository petRepository;
	
	@GetMapping("/pets")
	public ResponseEntity<List<PetModel>> getAllPets() {
		List<PetModel> petList= petRepository.findAll();
		if(!petList.isEmpty()) {
			for(PetModel pet : petList) {
				UUID id = pet.getId();
				pet.add(linkTo(methodOn(PetController.class).getOnePet(id)).withSelfRel());

			}
		}
		return ResponseEntity.status(HttpStatus.OK).body(petList);
		
	}
	
	@GetMapping("/pet/{id}")
	public ResponseEntity<Object> getOnePet(@PathVariable(value = "id") UUID id){
		Optional<PetModel> pet0 = petRepository.findById(id);
		
		if(pet0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found.");
		}
		pet0.get().add(linkTo(methodOn(PetController.class).getAllPets()).withRel("Pets List"));


		return ResponseEntity.status(HttpStatus.OK).body(pet0.get());
	}
	
	@GetMapping(value = "/{dono}/lista")
	public ResponseEntity<List<PetModel>> obterPorDono(@PathVariable(value = "dono") Integer dono ) {
		List<PetModel> dtos = service.obterPorDono(dono);
		
		if(dtos.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		ModelMapper mapper = new ModelMapper();
		List<PetModel> resp = dtos.stream()
				.map(dto -> mapper.map(dto, PetModel.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	
	@PostMapping("/pet")
	public ResponseEntity<PetModel> savePet(@RequestBody @Valid PetRecordDto petRecordDto ){
		var petModel= new PetModel();
		BeanUtils.copyProperties(petRecordDto, petModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(petRepository.save(petModel));
	}
	
	@PutMapping("/pet/{id}")
	public ResponseEntity<Object> updatePet(@PathVariable(value="id") UUID id,
														@RequestBody @Valid PetRecordDto petRecordDto){
		
		Optional<PetModel> pet0= petRepository.findById(id);
		if(pet0.isEmpty()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
		}
		var petModel= pet0.get();
		BeanUtils.copyProperties(petRecordDto, petModel);
		return ResponseEntity.status(HttpStatus.OK).body(petRepository.save(petModel));
		
	}
	
	@DeleteMapping("/pet/{id}")
	public ResponseEntity<Object> deletePet(@PathVariable(value = "id") UUID id) {
		Optional<PetModel> pet0= petRepository.findById(id);
		if(pet0.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pet not found");
		}
		petRepository.delete(pet0.get());
		return ResponseEntity.status(HttpStatus.OK).body("Pet deleted succesfully");
		
	}
	

}
