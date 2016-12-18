package clasesDAO.JPAHibernate;

import org.springframework.stereotype.Repository;

import clases.Professor;

import clasesDAO.ProfessorDAO;

@Repository
public class ProfessorDAOHibernate extends GenericDAOJPAHibernate<Professor> implements ProfessorDAO{

	
	public ProfessorDAOHibernate(){
		super(Professor.class);
	}

}
