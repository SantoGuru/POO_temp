package dao;

public interface GenericDAO<T>{
	public abstract T cadastrar(T object);
}
