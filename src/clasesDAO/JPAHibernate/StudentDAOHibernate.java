package clasesDAO.JPAHibernate;

import org.springframework.stereotype.Repository;

import clases.Student;
import clasesDAO.StudentDAO;

@Repository
public class StudentDAOHibernate extends GenericDAOJPAHibernate<Student> implements StudentDAO{

	
	public StudentDAOHibernate(){
		super(Student.class);
	}
	
}
