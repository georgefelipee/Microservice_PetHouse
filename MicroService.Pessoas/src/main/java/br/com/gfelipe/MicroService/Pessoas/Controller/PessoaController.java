package br.com.gfelipe.MicroService.Pessoas.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.text.Highlighter.HighlightPainter;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gfelipe.MicroService.Pessoas.Dto.PessoaDTO;
import br.com.gfelipe.MicroService.Pessoas.Model.PessoaModel;
import br.com.gfelipe.MicroService.Pessoas.Service.IPessoaService;
import br.com.gfelipe.MicroService.Pessoas.compartilhado.PessoaModelDetalhes;


@RestController
@RequestMapping("api/pessoas")
public class PessoaController {
	
	@Autowired
	private IPessoaService service;
	
	
	@PostMapping
	public ResponseEntity<PessoaModel> criarPessoa(@RequestBody @jakarta.validation.Valid PessoaModel pessoa) {
		ModelMapper mapper = new ModelMapper();
		PessoaDTO dto = mapper.map(pessoa, PessoaDTO.class);
		dto = service.criarPessoa(dto);
		
		return new ResponseEntity<>(mapper.map(dto, PessoaModel.class),HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaModel>> obterTodos() {
		List<PessoaDTO> dtos = service.obterTodos();
		if(dtos.isEmpty()) {
			return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ModelMapper mapper = new ModelMapper();
		List<PessoaModel> resp = dtos.stream()
				.map(dto -> mapper.map(dto, PessoaModel.class))
				.collect(Collectors.toList());
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaModelDetalhes> obterPorId(@PathVariable Integer id){
		Optional<PessoaModelDetalhes> pessoa = service.obterPorId(id);
		
		if(pessoa.isPresent()) {
			return new  ResponseEntity<>( new ModelMapper().map(pessoa.get(),PessoaModelDetalhes.class), HttpStatus.OK);
			
		}
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> atualizarPessoa(@PathVariable Integer id, @jakarta.validation.Valid @RequestBody PessoaDTO pessoa){
		ModelMapper mapper = new ModelMapper();
		PessoaDTO dto = mapper.map(pessoa, PessoaDTO.class);
		dto = service.atualizarPessoa(id, dto);
		
		return new ResponseEntity<>(mapper.map(dto, PessoaDTO.class),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> removerPessoa(@PathVariable Integer id) {
		
		service.removerPessoa(id);
		return ResponseEntity.status(HttpStatus.OK).body("Pessoa Deletada com sucesso!");
		
	}

}
