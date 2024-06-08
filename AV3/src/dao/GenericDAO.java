package dao;

import java.io.IOException;
import java.util.ArrayList;

public interface GenericDAO<T>{
	public abstract T consultar(T object, DataBase DB) throws IOException;
	public abstract T cadastrar(T object, DataBase DB) throws IOException;
	public abstract boolean editar(T object, DataBase DB) throws IOException;
	public abstract ArrayList<T> listar(T object, DataBase DB) throws IOException;
}
