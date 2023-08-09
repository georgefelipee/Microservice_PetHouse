package br.com.gfelipe.MicroService.Pessoas.Model;

public enum PessoasRoles {
	
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	PessoasRoles(String string) {
		this.role = role;
		// TODO Auto-generated constructor stub
	}

	public String getRole() {
		
		return role;
	}

}
