package view;
import java.io.IOException;

import dao.DataBase;
import domain.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase DB = new DataBase();
		// Criar hospede
		Hospede H1 = new Hospede("666.667.853-50", "Lucas", "lucas@gmail.com","Rua X");
		try {
			System.out.println(
				DB.hospedeDAO.cadastrar(
						DB.hospedeDAO.consultar(H1, DB), 
						DB)
				);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
