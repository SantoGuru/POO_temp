package view;

import java.io.IOException;

import dao.DataBase;
import domain.Hospede;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase DB = new DataBase();
		// Criar hospede
		Hospede H1 = new Hospede("666.667.853-51", "Luca1s", "lucas@gmail.com", "Rua X");
		Hospede H2 = new Hospede("666.667.853-52", "Luca2s", "lucas@gmail.com", "Rua X");
		Hospede H3 = new Hospede("666.667.853-53", "Luca3s", "lucas@gmail.com", "Rua X");
		Hospede H4 = new Hospede("666.667.853-55", "Luca31s", "lucas@gmail.com", "Rua X");
		try {
			DB.hospedeDAO.cadastrar(H1, DB);
			DB.hospedeDAO.cadastrar(H2, DB);
			DB.hospedeDAO.cadastrar(H3, DB);
			DB.hospedeDAO.cadastrar(H4, DB);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
