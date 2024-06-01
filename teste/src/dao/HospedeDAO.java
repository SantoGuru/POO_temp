package dao;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import domain.*;

public class HospedeDAO {	
	public Hospede consultar(Hospede hospede,DataBase DB) throws IOException{
			String linha;
			FileReader FR = new FileReader(DB.load("hospede"));
			BufferedReader BR = new BufferedReader(FR);
			while((linha = BR.readLine())!=null) {
				String[] dados = linha.split(",");
				if (dados.length > 0 && dados[0].toString().equals(hospede.getCPF())) {
					Hospede hospedeEncontrado = new Hospede(dados[0],dados[1],dados[2],dados[3]);
					BR.close();
					return hospedeEncontrado; //Retorno caso exista
				}
			}
		BR.close();
		return null; //Retorna não existente
	};
	
	public Hospede cadastrar(Hospede hospede,DataBase DB) throws IOException{
		Hospede consultaHospede = this.consultar(hospede, DB);
		if (consultaHospede.equals(null)){	
			// File/Buffer
			FileReader FR = new FileReader(DB.load("hospede"));
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(DB.load("hospede"),true);
			BufferedWriter BW = new BufferedWriter(FW);
			// newLine até uma linha vazia
			String linha;
			while((linha = BR.readLine())!=null) {
				BW.newLine();
			};
			// BufferedWriter 
			BW.write(hospede.toString());
			// Fechamento dos File/Buffer
			BR.close();
			BW.close();
			// Retorno do usuário recém cadastrado e fechamento do método
			return hospede;
		}else {
			// Retorno do usuário já cadastrado e fechamento do método
			return hospede;
		}
	};
}
