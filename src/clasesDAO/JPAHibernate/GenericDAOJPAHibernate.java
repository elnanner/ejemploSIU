package clasesDAO.JPAHibernate;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import org.springframework.transaction.annotation.Transactional;

import clasesDAO.GenericDAO;


@Transactional
public class GenericDAOJPAHibernate<T> implements GenericDAO<T> {

	protected Class<T> persistentClass;
	
	
	protected   EntityManager  emf;
	
	
	private void GenericDAOJPAHibernate(){

	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
	this.emf = em;
	}
	public EntityManager getEntityManager() {
	return emf;
	}
	
	public GenericDAOJPAHibernate(Class clase) {
		persistentClass = clase;
    }
	
	
	
	@Override
	public T update(T entity) {
		T devolution=this.getEntityManager().merge(entity);
		return devolution;
	}

	@Override
	public void delete(T entity) {
		this.getEntityManager().remove(entity);
	}

	@Override
	public boolean exists(Long id) {
		T search=get(id);
		if(search==null){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public T persist(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}

	@Override
	public T get(Long id) {
		T result = null;
		result=this.getEntityManager().find(persistentClass, id);
		return result;
	}
	
	
    @Override
	public ArrayList<T> getAllWithoutOrder(){
		ArrayList<T> result = new ArrayList<T>();
		result= (ArrayList<T>)(this.getEntityManager().createQuery("SELECT table FROM "+this.getPersistentClass().getSimpleName()  +" table")).getResultList();
		return result;
	}
	
	//lo bajaria a los que tienen baja logica (user, board, comment y note)
	public ArrayList<T> getAllWithoutOrderAndNotLogicDelete(){
		ArrayList<T> result = new ArrayList<T>();
		result=(ArrayList<T>)(this.getEntityManager().createQuery("SELECT table FROM "+this.getPersistentClass().getSimpleName()  +" table where delete=0")).getResultList();
		return result;
	}
	
	//lo bajaria a los que tienen baja logica (user, board, comment y note)
	public void logicDelete(Long id){
		Query q=this.getEntityManager().createQuery("update "+this.getPersistentClass().getSimpleName()+" set delete = 1 where id = ? ");
		q.setParameter(1,id);
		q.getResultList();
	}
	
	
	
	@Override
	public Integer getCount() {
		List result = (this.getEntityManager().createQuery("SELECT table FROM "+this.getPersistentClass().getSimpleName()  +" table")).getResultList();
		return result.size() ;
	}
	
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@Override
	public Long loginSIU(String user, String pass) {
		Class currentClass=this.getPersistentClass();
		Query q=this.getEntityManager().createQuery("select id from "+this.getPersistentClass().getSimpleName()+" table where user = 1 and pass = 2 ");
		q.setParameter(1,user);
		q.setParameter(2,pass);
	      List res = q.getResultList();
		if(res.size()!=0){
			return (Long) res.get(0);
		}else{
			return null;
		}
	}

	@Override
	public T login(String user, String pass) {
		System.out.println("Inicio login "+user+" "+pass);
		Class currentClass=this.getPersistentClass();
		Query q=this.getEntityManager().createQuery("select table from "+this.getPersistentClass().getSimpleName()+" table where user = ?1 and pass = ?2 ");
		q.setParameter(1,user);
		q.setParameter(2,pass);
	    List res = q.getResultList();
	    System.out.println("Estoy adentro de consulta res, "+res.size());
		if(res.size()!=0){
			return (T) res.get(0);
		}else{
			return null;
		}
	}



}
