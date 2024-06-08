package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Item;

public class ItemDAO implements GenericDAO<Item> {
	@Override
	public Item consultar(Item item, DataBase DB) throws IOException {
		String linha;
		FileReader FR = new FileReader(DB.load("Item"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			String[] dados = linha.split(",");
			if (dados.length > 0 && Integer.parseInt(dados[0]) == item.getCodigo()) {
				Item ItemEncontrado = new Item(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
				BR.close();
				return ItemEncontrado;
			}
		}
		BR.close();
		return null;
	};

	@Override
	public Item cadastrar(Item Item, DataBase DB) throws IOException {
		Item consultaItem = this.consultar(Item, DB);
		if (consultaItem == null) {
			File ItemDB = DB.load("Item");
			FileReader FR = new FileReader(ItemDB);
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(ItemDB, true);
			BufferedWriter BW = new BufferedWriter(FW);
			if (BR.readLine() == null) {
				BW.write(Item.toString());
			} else {
				BW.newLine();
				BW.write(Item.toString());
			}
			;
			BR.close();
			BW.close();
			System.out.println("Item cadastrado!");
			return Item;
		} else {
			System.out.println("ERRO: Item já cadastrado!");
			return null;
		}
	}

	public ArrayList<Item> listar(Item item, DataBase DB) throws IOException {
		ArrayList<Item> Items = new ArrayList<Item>();
		String linha;
		FileReader FR = new FileReader(DB.load("Item"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			Item ItemListado = new Item(0, "", 0.0);
			ItemListado.toObject(linha);
			Items.add(ItemListado);
		}
		BR.close();
		return Items;
	}
	public boolean editar(Item item, DataBase DB) throws IOException {
		Item consultaItem = this.consultar(item, DB);
		if (consultaItem != null) {
			ArrayList<Item> AL = this.listar(null, DB);
			for (int i=0;i<AL.size();i++) {
				if(AL.get(i).getCodigo() == item.getCodigo()){
					AL.remove(i);
					AL.add(item);
					File arquivo = DB.load("Item");
					arquivo.delete();
				}
			}
			FileWriter FW = new FileWriter(DB.filePath+"ItemDB"+DB.fileType, true);
			BufferedWriter BW = new BufferedWriter(FW);
			for (Item h : AL) {
				BW.write(h.toString());
				BW.newLine();
			}
			BW.close();
			return true;
		}
		return false;
	}

}
