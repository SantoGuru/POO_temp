package view;

import java.io.IOException;

import dao.DataBase;
import domain.Categoria;
import domain.Hospede;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase DB = new DataBase();
		// Criar hospede
		Categoria C1 = new Categoria(0, "testando", 0.0);
		try {
			DB.categoriaDAO.cadastrar(C1, DB);
			DB.categoriaDAO.consultar(C1, DB);
			DB.categoriaDAO.editar(C1, DB);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
