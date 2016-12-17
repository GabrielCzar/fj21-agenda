package br.caelum.bd.dao;

import java.util.List;

public interface IGenericDao<T, I>{

	//Objetos unicos
	public boolean create(T object);
	public T read(Class<T> objectName, I id);
	public boolean update(T object);
	public void delete(T object);
	
	//Todos os objetos
	public List<T> readAll(Class<T> objectName, String jpql);
	public void delete(Class<T> objectName, I id);

}

