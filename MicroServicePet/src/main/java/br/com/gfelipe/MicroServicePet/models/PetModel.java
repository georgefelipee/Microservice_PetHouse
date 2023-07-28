package br.com.gfelipe.MicroServicePet.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "TB_PETS")
public class PetModel extends RepresentationModel<PetModel> implements Serializable  {
	
	public static final long serialVersionUID=1;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String nome;
	
	private String raca;
	
	private Integer dono;
	
	
	public Integer getDono() {
		return dono;
	}

	public void setDono(Integer dono) {
		this.dono = dono;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
