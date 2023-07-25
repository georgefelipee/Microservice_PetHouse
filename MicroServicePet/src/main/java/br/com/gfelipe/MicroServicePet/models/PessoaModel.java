package br.com.gfelipe.MicroServicePet.models;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


public class PessoaModel extends RepresentationModel<PessoaModel> implements Serializable{
	
	public static final long serialVersionUID=1;
	private UUID id;
	
	private String nome;
	private String cidade;
	private String estado;
	private Long numCelular;
	private Integer idade;
	
	
	
	
	public UUID getIdPessoa() {
		return id;
	}
	public void setIdPessoa(UUID idPessoa) {
		this.id = idPessoa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Long getNumCelular() {
		return numCelular;
	}
	public void setNumCelular(Long numCelular) {
		this.numCelular = numCelular;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
