package view;
import dao.DataBase;
import domain.*;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataBase DB = new DataBase();
		// Criar hospede
		Hospede H1 = new Hospede("Rua X", "666.667.853-50", "Lucas", "lucas@gmail.com");
		
		DB.load();
	}

}
