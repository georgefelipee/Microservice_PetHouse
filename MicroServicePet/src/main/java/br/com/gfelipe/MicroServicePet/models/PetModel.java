package br.com.gfelipe.MicroServicePet.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
