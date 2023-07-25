package br.com.gfelipe.MicroServicePet.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import br.com.gfelipe.MicroServicePet.dto.PetRecordDto;
import br.com.gfelipe.MicroServicePet.models.PetModel;

public interface IPetService {
	
	PetRecordDto criarAnimal(PetRecordDto pet);
	List<PetRecordDto> obterTodos();
	Optional<PetRecordDto>obterPorId(UUID id);
	List<PetModel> obterPorDono(Integer dono);
	void removerAnimal(UUID id);
	PetRecordDto atualizarAnimal(UUID id, PetRecordDto pet);
	

}
