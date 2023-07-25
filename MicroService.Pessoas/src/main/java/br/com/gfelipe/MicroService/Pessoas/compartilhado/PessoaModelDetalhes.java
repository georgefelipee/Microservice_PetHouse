package br.com.gfelipe.MicroService.Pessoas.compartilhado;

import java.util.List;

public class PessoaModelDetalhes {
	
	private Integer id;
	
	private String nome;
	private String cidade;
	private String estado;
	private List<AnimalDTO> pets;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public List<AnimalDTO> getPets() {
		return pets;
	}
	public void setPets(List<AnimalDTO> pets) {
		this.pets = pets;
	}
	
	
	

}
