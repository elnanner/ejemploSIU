package clasesDAO;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public interface GenericDAO<T> {

	public T update(T entity);
	public void delete(T entity);
	//public T borrar(Long id);
	public boolean exists(Long id);
	public T persist(T entity);
	public T get(Long id);
	public Integer getCount();
	public ArrayList<T> getAllWithoutOrder(); 
	public Long loginSIU(String user, String pass);
	public T login(String user, String pass);
	
}
