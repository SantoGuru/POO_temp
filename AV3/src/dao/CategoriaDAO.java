package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import domain.Categoria;

public class CategoriaDAO implements GenericDAO<Categoria> {
	@Override
	public Categoria consultar(Categoria categoria, DataBase DB) throws IOException {
		String linha;
		FileReader FR = new FileReader(DB.load("Categoria"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			String[] dados = linha.split(",");
			if (dados.length > 0 && Integer.parseInt(dados[0]) == categoria.getCodigo()) {
				Categoria CategoriaEncontrado = new Categoria(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]));
				BR.close();
				return CategoriaEncontrado;
			}
		}
		BR.close();
		return null;
	};

	@Override
	public Categoria cadastrar(Categoria categoria, DataBase DB) throws IOException {
		Categoria consultaCategoria = this.consultar(categoria, DB);
		if (consultaCategoria == null) {
			File CategoriaDB = DB.load("Categoria");
			FileReader FR = new FileReader(CategoriaDB);
			BufferedReader BR = new BufferedReader(FR);
			FileWriter FW = new FileWriter(CategoriaDB, true);
			BufferedWriter BW = new BufferedWriter(FW);
			if (BR.readLine() == null) {
				BW.write(categoria.toString());
			} else {
				BW.newLine();
				BW.write(categoria.toString());
			}
			;
			BR.close();
			BW.close();
			System.out.println("Categoria cadastrado!");
			return categoria;
		} else {
			System.out.println("ERRO: Categoria já cadastrado!");
			return null;
		}
	}

	public ArrayList<Categoria> listar(Categoria categoria, DataBase DB) throws IOException {
		ArrayList<Categoria> Categorias = new ArrayList<Categoria>();
		String linha;
		FileReader FR = new FileReader(DB.load("Categoria"));
		BufferedReader BR = new BufferedReader(FR);
		while ((linha = BR.readLine()) != null) {
			Categoria CategoriaListado = new Categoria(0, "", 0.0);
			CategoriaListado.toObject(linha);
			Categorias.add(CategoriaListado);
		}
		BR.close();
		return Categorias;
	}
	public boolean editar(Categoria categoria, DataBase DB) throws IOException {
		Categoria consultaCategoria = this.consultar(categoria, DB);
		if (consultaCategoria != null) {
			ArrayList<Categoria> AL = this.listar(null, DB);
			for (int i=0;i<AL.size();i++) {
				if(AL.get(i).getCodigo() == categoria.getCodigo()){
					AL.remove(i);
					AL.add(categoria);
					File arquivo = DB.load("Categoria");
					arquivo.delete();
				}
			}
			FileWriter FW = new FileWriter(DB.filePath+"CategoriaDB"+DB.fileType, true);
			BufferedWriter BW = new BufferedWriter(FW);
			for (Categoria h : AL) {
				BW.write(h.toString());
				BW.newLine();
			}
			BW.close();
			return true;
		}
		return false;
	}

}
