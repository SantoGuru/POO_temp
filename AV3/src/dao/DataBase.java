package dao;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
	public String filePath = "./Files/";
	public String fileType = ".txt";
	public ArrayList<File> DBfiles = new ArrayList<File>();
	public HospedeDAO hospedeDAO = new HospedeDAO();
	public CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	public File load(String nome){
		String nomeDB = nome+"DB.txt";
		for (int i=0;i<DBfiles.size();i++){
			if (DBfiles.get(i).getName().equals(nomeDB)){
				return DBfiles.get(i);
			}
		}
		return null;
	}
		
	public DataBase(){
		File hospedeDB = new File(filePath+"hospedeDB"+fileType);
		File CategoriaDB = new File(filePath+"CategoriaDB"+fileType);
		File ItemDB = new File(filePath+"ItemDB"+fileType);
		if(hospedeDB.exists()){
			DBfiles.add(hospedeDB);
			System.out.println("Carregado: hospedeDB");
		}else {
			try {
				FileWriter FW = new FileWriter(filePath+"hospedeDB"+".txt",true);
				FW.close();
				DBfiles.add(hospedeDB);
				System.out.println("Criado: hospedeDB");
			}catch(IOException e){
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
			}
		}
		
		if(CategoriaDB.exists()){
			DBfiles.add(CategoriaDB);
			System.out.println("Carregado: CategoriaDB");
		}else {
			try {
				FileWriter FW = new FileWriter(filePath+"CategoriaDB"+".txt",true);
				FW.close();
				DBfiles.add(CategoriaDB);
				System.out.println("Criado: CategoriaDB");
			}catch(IOException e){
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
			}
		}
		if(ItemDB.exists()){
			DBfiles.add(ItemDB);
			System.out.println("Carregado: ItemDB");
		}else {
			try {
				FileWriter FW = new FileWriter(filePath+"ItemDB"+".txt",true);
				FW.close();
				DBfiles.add(CategoriaDB);
				System.out.println("Criado: ItemDB");
			}catch(IOException e){
				System.out.println(e.getCause());
				System.out.println(e.getMessage());
			}
		}
	}
}
