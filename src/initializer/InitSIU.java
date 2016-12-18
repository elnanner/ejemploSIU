package initializer;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import clases.Professor;
import clases.Student;
import clasesDAO.ProfessorDAO;
import clasesDAO.StudentDAO;

@Component
public class InitSIU {

	@Autowired 
	private StudentDAO studentDAO;
	
	@Autowired 
	private ProfessorDAO professorDAO;
	
	
	public  void init(){
		System.out.println(" in init" );
		System.out.println("sutdend count es "+studentDAO.getCount());
		if(studentDAO.getCount()==0){
			System.out.println(" in iIFFF" );
		Student s1=new Student("juan","perez","juanperez@gmail.com","alu","alu");
		studentDAO.persist(s1);
	    
		Student s2=new Student("pepito","el grillo","pepe@gmail.com","alu1","alu1");
		studentDAO.persist(s2);
		
		Student s3=new Student("margarita","l' flor","margarina@gmail.com","alu2","alu2");
		studentDAO.persist(s3);
		
		Student s4=new Student("bart","simpson","elBarto@gmail.com","bart","barto");
		studentDAO.persist(s4);
		
		System.out.println(" persistiendo alumno" +s4.getApellidos());
		
		Collection<Integer> a1=new ArrayList<Integer>();
		a1.add(1);a1.add(2);a1.add(3);
		Professor p1=new Professor("profesor","jirafales","profjirafa@gmail.com",a1,"prof","prof");
		professorDAO.persist(p1);
		
		Collection<Integer> a2=new ArrayList<Integer>();
		a2.add(1);
		Professor p2=new Professor("profesor","neurus","profneurus@gmail.com",a2,"prof1","prof1");
		professorDAO.persist(p2);
		
		
		}
		
	}
	
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}



	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}



	public ProfessorDAO getProfessorDAO() {
		return professorDAO;
	}



	public void setProfessorDAO(ProfessorDAO professorDAO) {
		this.professorDAO = professorDAO;
	}



	public InitSIU() { }
	
	
}
