package br.com.gfelipe.MicroService.Pessoas.compartilhado;

	
	import java.util.List;
	import java.util.UUID;

	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;

public class AnimalDTO {

		
		private UUID id;
		
		private String nome;
		
		private String raca;
		
		private Integer dono;

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

		public String getRaca() {
			return raca;
		}

		public void setRaca(String raca) {
			this.raca = raca;
		}

		public Integer getDono() {
			return dono;
		}

		public void setDono(Integer dono) {
			this.dono = dono;
		}
		
		

	}



