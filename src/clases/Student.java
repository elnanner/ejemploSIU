package clases;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Student {

	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	protected String nombres;
	protected String apellidos;
	protected String email;

	protected String user;
	protected String pass;
	public Student(){ }
	
	

	public Student(String nombresParam,String apellidosParam,String mailParam,String userParam, String passParam ) {
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
