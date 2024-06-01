package domain;

import java.util.ArrayList;

public class Funcionario extends Pessoa{
	private String setor;
	
	
	public Boolean cadastro(Funcionario F) {
		return true; // TODO:RETORNAR ALGO
	}
	public Boolean editar(Funcionario F) {
		return true; // TODO:RETORNAR ALGO
	}
	public Funcionario consultar(Funcionario F) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Funcionario> listar(Funcionario F) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public Funcionario(String setor,String cpf,String nome,String email) {
		super(cpf, nome, email);
		this.setor = setor;
	};
	
}
