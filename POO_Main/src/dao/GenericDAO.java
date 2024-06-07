package dao;

import java.io.IOException;

public interface GenericDAO<T>{
	public abstract T consultar(T object, DataBase DB) throws IOException;;
	public abstract T cadastrar(T object, DataBase DB) throws IOException;;
}
