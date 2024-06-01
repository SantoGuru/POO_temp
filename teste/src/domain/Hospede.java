package domain;

import java.io.IOException;
import java.util.ArrayList;

import dao.*;

public class Hospede extends Pessoa{
	private String enderecoCompleto;
	
	public Boolean editar(Hospede H) {
		return true; // TODO:RETORNAR ALGO
	}
	public Hospede consultar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Hospede> listar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public Hospede(String cpf, String nome, String email,String endereco){
		super(cpf,nome,email);
		this.setEnderecoCompleto(endereco);
	}
	
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	
	@Override
	public String toString(){
		return this.getCPF()+","+this.getNome()+","+this.getEmail()+","+this.getEnderecoCompleto();
	};
	
	
}