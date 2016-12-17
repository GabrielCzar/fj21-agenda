package br.caelum.bd.dao;

import java.util.List;

import javax.persistence.PersistenceContext;

public class GenericDao<T> implements IGenericDao<T> {
	
	/**
	 * @var EntityManagerFactory construida a partir do persistence.xml
	 */
	private EntityManagerFactory factory;
	
	/**
	 * @var EntityManager construida a partir do EntityManagerFactory
	 */
	private EntityManager manager;

	
	/**
	 * @constructor construtor que instância as classes EntityManagerFactory
	 * e EntityManager a partir do nome atribuido ao persistence.xml criando
	 * a conexão com o banco
	 * 
	 * @param String namePersistence
	 */
	public GenericDAOHibernate(String namePersistence) {
		this.factory = Persistence.createEntityManagerFactory(namePersistence);
		this.manager = factory.createEntityManager();
	}

	/**
     * INSERT
     * Insere uma nova tupla
     * 
     * @param class<T> object
     *  
     * @return boolean
     */
	@Override
	public boolean create(T object) {
		try{
			this.manager.getTransaction().begin();
			this.manager.persist(object);
			this.manager.getTransaction().commit();
			return true;
		}catch(PersistenceException e){
			return false;
		}
	}

	/**
     * READ
     * Busca pelo ID e retorna um T object
     * 
     * @param Class<T> objectName
     * @param Long id
     * 
     * @return T object
     */
	@Override
	public T read(Class<T> objectName, Long id) {
		return this.manager.find(objectName , id);
	}

	/**
     * UPDATE
     * Atualiza uma tupla a partir de um cass<T> object
     * 
     * @param class<T> object
     * 
     * @return boolean
     */
	@Override
	public boolean update(T object) {
		try{
			this.manager.getTransaction().begin();
			this.manager.merge(object);
			this.manager.getTransaction().commit();
			return true;
		}catch (PersistenceException e) {
			return false;
		}
	}

	/**
     * DELETE
     * Deleta uma tupla pela class<T> object.
     * 
     * @param class<T> object
     * 
     * @return boolean
     */
	@Override
	public void delete(T object) {
		this.manager.getTransaction().begin();
		this.manager.remove(object);
		this.manager.getTransaction().commit();
	}

	/**
     * READ
     * Busca a partir uma consulta jpql.
     * 
     * @param Class<T> objectName 
     * @param String jpql
     * 
     * @return List<T>
     * 
     * @exception IllegalArgumentException
     */
	@Override
	public List<T> readAll(Class<T> objectName, String jpql) {
		try{
			return manager.createQuery(jpql, objectName).getResultList();
		}catch (IllegalArgumentException e) {
			return null;
		}
	}

	/**
     * DELETE
     * Deleta uma tupla pela class T object.
     * 
     * @param class<T> objectName
     * @param Long id 
     *     
     * @return boolean
     */
	@Override
	public void delete(Class<T> objectName, Long id) {
		try{
			T t = manager.find(objectName, id); 
			manager.getTransaction().begin();
			manager.remove(t);
			manager.getTransaction().commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
