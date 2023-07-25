package br.com.gfelipe.MicroServicePet.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import br.com.gfelipe.MicroServicePet.dto.PetRecordDto;
import br.com.gfelipe.MicroServicePet.models.PetModel;
import br.com.gfelipe.MicroServicePet.repositories.IPetRepository;

@Service
public class PetServiceImplementacao implements IPetService {
	
	@Autowired
	private IPetRepository repo;
	

	@Override
	public PetRecordDto criarAnimal(PetRecordDto pet) {

		return salvarAnimal(pet);
	}

	@Override
	public List<PetRecordDto> obterTodos() {
		List<PetModel> pets = repo.findAll();
		
		return pets.stream()
				.map(pet -> new ModelMapper().map(pet, PetRecordDto.class))
				.collect(Collectors.toList())
				;
	}

	@Override
	public Optional<PetRecordDto> obterPorId(UUID id) {
		Optional<PetModel> pet = repo.findById(id);
		if(pet.isPresent()) {
			return Optional.of(new ModelMapper().map(pet.get(), PetRecordDto.class));
			
		}
		
		return Optional.empty();
	}

	@Override
	public List<PetModel> obterPorDono(Integer dono) {
		List<PetModel> pets = repo.findByDono(dono);
		
		return pets.stream()
				.map(pet -> new ModelMapper().map(pet, PetModel.class))
				.collect(Collectors.toList());
	}

	@Override
	public void removerAnimal(UUID id) {
		repo.deleteById(id);
		
	}

	@Override
	public PetRecordDto atualizarAnimal(UUID id, PetRecordDto pet) {
		
		return salvarAnimal(pet);
	}

	private PetRecordDto salvarAnimal(PetRecordDto pet) {
		ModelMapper mapper = new ModelMapper();
		PetModel petEntidade = mapper.map(pet, PetModel.class);
		petEntidade = repo.save(petEntidade);
		
		return mapper.map(petEntidade, PetRecordDto.class);
	}
	

}
