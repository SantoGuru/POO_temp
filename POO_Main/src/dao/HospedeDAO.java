package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Hospede;

public class HospedeDAO implements GenericDAO<Hospede> {
	@Override
	public Hospede consultar(Hospede hospede, DataBase DB) throws IOException {
		String linha;
		FileReader FR = new FileReader(DB.load("hospede"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			String[] dados = linha.split(",");
			if (dados.length > 0 && dados[0].toString().equals(hospede.getCPF())) {
				Hospede hospedeEncontrado = new Hospede(dados[0], dados[1], dados[2], dados[3]);
				BR.close();
				return hospedeEncontrado;
			}
		}
		BR.close();
		return null;
	};

	@Override
	public Hospede cadastrar(Hospede hospede, DataBase DB) throws IOException {
		Hospede consultaHospede = this.consultar(hospede, DB);
		if (consultaHospede == null) {
			File hospedeDB = DB.load("hospede");
			FileReader FR = new FileReader(hospedeDB);
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(hospedeDB, true);
			BufferedWriter BW = new BufferedWriter(FW);
			if (BR.readLine() == null) {
				BW.write(hospede.toString());
			} else {
				BW.newLine();
				BW.write(hospede.toString());
			}
			;
			BR.close();
			BW.close();
			System.out.println("Hospede cadastrado!");
			return hospede;
		} else {
			System.out.println("ERRO: Hospede já cadastrado!");
			return null;
		}
	}

	public ArrayList<Hospede> listar(Hospede hospede, DataBase DB) throws IOException {
		// TODO: PERGUNTAR PQ TO PASSANDO UM HOSPEDE
		ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
		String linha;
		FileReader FR = new FileReader(DB.load("hospede"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			Hospede hospedeListado = new Hospede("", "", "", "");
			hospedeListado.toObject(linha);
			hospedes.add(hospedeListado);
		}
		BR.close();
		return hospedes;
	}

	// TODO: ENTENDI NADA DESSA MERDA
	public boolean editar(Hospede hospede, DataBase DB) throws IOException {
		Hospede consultaHospede = this.consultar(hospede, DB);
		if (consultaHospede != null) {
			return true;
		}
		return false;
	}

}
