package domain;

import java.util.ArrayList;

public class Hospede extends Pessoa{
	private String enderecoCompleto;
	
	public Boolean cadastro(Hospede H) {
		return true; // TODO:RETORNAR ALGO
	}
	public Boolean editar(Hospede H) {
		return true; // TODO:RETORNAR ALGO
	}
	public Hospede consultar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Hospede> listar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public Hospede(String endereco,String cpf, String nome, String email){
		super(cpf,nome,email);
		this.enderecoCompleto = endereco;
		//TODO:ALGO PRA MOSTRAR Q FALHOU!
		this.cadastro(this);
	
	}
	
}
