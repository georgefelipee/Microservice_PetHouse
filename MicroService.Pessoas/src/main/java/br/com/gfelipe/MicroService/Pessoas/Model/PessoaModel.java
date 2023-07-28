package br.com.gfelipe.MicroService.Pessoas.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


@Entity
@Table(name = "TB_PESSOASS")
public class PessoaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String cidade;
	@Column(nullable = false, unique = true)
	@Pattern(regexp = ".+@.+\\..+", message = "Email inválido")
	private String email;
	@Column(nullable = false)
	private Long tel;
	@Column(nullable = false)
	private String estado;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
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
	
	

}
