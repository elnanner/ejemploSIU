package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clases.Professor;

import clasesDAO.ProfessorDAO;


@RestController
public class ProfessorController {

	@Autowired 
	private ProfessorDAO professorDAO;
	
	public ProfessorController(){  }
	
	public ProfessorDAO getStudentDAO() {
		return professorDAO;
	}
	
	public void setProfessorDAO(ProfessorDAO professorDAOParam) {
		this.professorDAO = professorDAOParam;
	}
	
	
	@RequestMapping(value="/profesores",method = RequestMethod.GET ,headers="Accept=application/json")
	public  ResponseEntity<ArrayList<Professor>> listAllStudents() {
		ArrayList<Professor> professors =professorDAO.getAllWithoutOrder();
		if(professors.isEmpty()){
			return new ResponseEntity<ArrayList<Professor>>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<ArrayList<Professor>>(professors,HttpStatus.OK);
	}
	
	@RequestMapping(value="/profesores/{id}", method = RequestMethod.GET , produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Professor> listStudent(@PathVariable("id") Long idProf) {
		Professor professor = professorDAO.get(idProf);
		if(professor==null){
			return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Professor>(professor, HttpStatus.OK);
	}
	
	
}
