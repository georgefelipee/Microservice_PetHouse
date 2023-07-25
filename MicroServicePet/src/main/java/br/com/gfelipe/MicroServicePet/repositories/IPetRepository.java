package br.com.gfelipe.MicroServicePet.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gfelipe.MicroServicePet.models.PetModel;

@Repository
public interface IPetRepository extends JpaRepository<PetModel, UUID> {

	

	List<PetModel> findByDono(Integer dono);
}
