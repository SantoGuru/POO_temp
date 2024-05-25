package domain;

import java.util.ArrayList;

public class Item {
	private int codigo;
	private String descricao;
	private double valor;
	
	public Boolean cadastro(Item I) {
		return true; // TODO:RETORNAR ALGO
	}
	public Boolean editar(Item I) {
		return true; // TODO:RETORNAR ALGO
	}
	public Item consultar(Item I) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Item> listar(Item I) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public Item(int codigo,String descricao,double valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
}
