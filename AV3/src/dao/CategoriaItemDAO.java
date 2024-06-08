package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.CategoriaItem;

public class CategoriaItemDAO implements GenericDAO<CategoriaItem> {
	//TODO: REFAZER!
	@Override
	public CategoriaItem consultar(CategoriaItem categoriaItem, DataBase DB) throws IOException {
		String linha;
		FileReader FR = new FileReader(DB.load("CategoriaItem"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			String[] dados = linha.split(",");
			if (dados.length > 0 && Integer.parseInt(dados[0]) == categoriaItem.getCodigo()) {
				CategoriaItem CategoriaItemEncontrado = new CategoriaItem(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
				BR.close();
				return CategoriaItemEncontrado;
			}
		}
		BR.close();
		return null;
	};

	@Override
	public CategoriaItem cadastrar(CategoriaItem CategoriaItem, DataBase DB) throws IOException {
		CategoriaItem consultaCategoriaItem = this.consultar(CategoriaItem, DB);
		if (consultaCategoriaItem == null) {
			File CategoriaItemDB = DB.load("CategoriaItem");
			FileReader FR = new FileReader(CategoriaItemDB);
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(CategoriaItemDB, true);
			BufferedWriter BW = new BufferedWriter(FW);
			if (BR.readLine() == null) {
				BW.write(CategoriaItem.toString());
			} else {
				BW.newLine();
				BW.write(CategoriaItem.toString());
			}
			;
			BR.close();
			BW.close();
			System.out.println("CategoriaItem cadastrado!");
			return CategoriaItem;
		} else {
			System.out.println("ERRO: CategoriaItem já cadastrado!");
			return null;
		}
	}

	public ArrayList<CategoriaItem> listar(CategoriaItem CategoriaItem, DataBase DB) throws IOException {
		ArrayList<CategoriaItem> CategoriaItems = new ArrayList<CategoriaItem>();
		String linha;
		FileReader FR = new FileReader(DB.load("CategoriaItem"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			CategoriaItem CategoriaItemListado = new CategoriaItem(0, "", 0.0);
			CategoriaItemListado.toObject(linha);
			CategoriaItems.add(CategoriaItemListado);
		}
		BR.close();
		return CategoriaItems;
	}
	public boolean editar(CategoriaItem CategoriaItem, DataBase DB) throws IOException {
		CategoriaItem consultaCategoriaItem = this.consultar(CategoriaItem, DB);
		if (consultaCategoriaItem != null) {
			ArrayList<CategoriaItem> AL = this.listar(null, DB);
			for (int i=0;i<AL.size();i++) {
				if(AL.get(i).getItem() == CategoriaItem.getCodigo()){
					AL.remove(i);
					AL.add(CategoriaItem);
					File arquivo = DB.load("CategoriaItem");
					arquivo.delete();
				}
			}
			FileWriter FW = new FileWriter(DB.filePath+"CategoriaItemDB"+DB.fileType, true);
			BufferedWriter BW = new BufferedWriter(FW);
			for (CategoriaItem h : AL) {
				BW.write(h.toString());
				BW.newLine();
			}
			BW.close();
			return true;
		}
		return false;
	}

}
