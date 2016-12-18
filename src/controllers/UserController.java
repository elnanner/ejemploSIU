package controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import clases.Credential;
import clases.Professor;
import clases.Student;

import clasesDAO.ProfessorDAO;
import clasesDAO.StudentDAO;


@RestController
public class UserController {
	//@Autowired
//	private UserDAO userDAO;
//
//	public UserController(){
//		
//	}
//	public UserDAO getUserDAO() {
//		return userDAO;
//	}
//
//	public void setUserDAO(UserDAO userDAO) {
//		this.userDAO = userDAO;
//	}
//	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ProfessorDAO professorDAO;
	
	public UserController(){
		
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


	
	@RequestMapping(value="/tryLoginS/", method = RequestMethod.POST) //el ultimo / 
	public ResponseEntity<Student> getStudent(@RequestBody Credential credential) {
		
		/*Este metodo recibe o espera recibir  el json con formato {"user": "userName", "pass":"pasname"}*/
		System.out.println("inicio trylogin student ponele");
		System.out.println(credential.getUser()+" "+ credential.getPass());
		Student user = studentDAO.login(credential.getUser(), credential.getPass());
		if(user==null){
			System.out.println("dentro de if trylogin student ponele");
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		System.out.println("ultimo antes trylogin student ponele");
		return new ResponseEntity<Student>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/tryLoginP/", method = RequestMethod.POST)
	public ResponseEntity<Professor> getProfessor(@RequestBody Credential credential) {
		System.out.println("inicio trylogin profesor ponele");
		Professor profesor = professorDAO.login(credential.getUser(), credential.getPass());
		if(profesor==null){
			System.out.println("dentro de if trylogin profesor ponele");
			return new ResponseEntity<Professor>(HttpStatus.NOT_FOUND);
		}
		System.out.println("ultimo antes trylogin ponele");
		return new ResponseEntity<Professor>(profesor, HttpStatus.OK);
	}
	
}
