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
	
	public File load(String nome){
		String nomeDB = nome+"DB.txt";
		for (int i=0;i<DBfiles.size();i++){
			//System.out.println(DBfiles.get(i).getName());
			if (DBfiles.get(i).getName().equals(nomeDB)){
				return DBfiles.get(i);
			}
		}
		return null;
	}
		
	public DataBase(){
		File hospedeDB = new File(filePath+"hospedeDB"+fileType);
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
	}
}
