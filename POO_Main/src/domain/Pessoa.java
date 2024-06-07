package domain;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private String email;
	
	public Pessoa(String cpf, String nome, String email){
		this.setCPF(cpf);
		this.setNome(nome);
		this.setEmail(email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}
	
	
}
