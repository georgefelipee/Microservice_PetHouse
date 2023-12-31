package br.com.gfelipe.MicroService.Pessoas.http;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.gfelipe.MicroService.Pessoas.compartilhado.AnimalDTO;

@FeignClient(value = "animais-ms",url = "http://localhost:8083/")
public interface AnimaisFeignClient {
		
	@GetMapping(path = "/{dono}/lista")
	public	List<AnimalDTO> obterAnimais(@PathVariable Integer dono);

		
}


