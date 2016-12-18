package clases;



import java.util.Collection;
import java.util.List;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Professor{
		
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	
	@ElementCollection(fetch = FetchType.EAGER)
	private Collection<Integer> anios;
	
	protected String nombres;
	protected String apellidos;
	protected String email;

	protected String user;
	protected String pass;
	public Professor(){ }
	
	public void addAnio(Integer anio) {
		anios.add(anio);
	}

	public Professor(String nombresParam,String apellidosParam,String mailParam, Collection<Integer> aniosParam,String userParam, String passParam ) {
		anios=aniosParam;
		nombres=nombresParam;
		apellidos=apellidosParam;
		email=mailParam;
		user=userParam;
		pass=passParam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Integer> getAnios() {
		return anios;
	}

	public void setAnios(Collection<Integer> anios) {
		this.anios = anios;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
