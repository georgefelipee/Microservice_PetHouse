package br.com.gfelipe.MicroServicePet.models;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;


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
