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

import clases.Student;
import clasesDAO.StudentDAO;

@RestController
public class StudentController {
	
	@Autowired 
	private StudentDAO studentDAO;
	
	public StudentController(){  }
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	
	public void setStudentDAO(StudentDAO studentDAOParam) {
		this.studentDAO = studentDAOParam;
	}
	

	@RequestMapping(value="/alumnos",method = RequestMethod.GET ,headers="Accept=application/json")
	public  ResponseEntity<ArrayList<Student>> listAllStudents() {
		ArrayList<Student> students = studentDAO.getAllWithoutOrder();
		if(students.isEmpty()){
			return new ResponseEntity<ArrayList<Student>>(HttpStatus.NO_CONTENT);
		} 
		return new ResponseEntity<ArrayList<Student>>(students,HttpStatus.OK);
	}
	
	@RequestMapping(value="/alumnos/{id}", method = RequestMethod.GET , produces =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> listStudent(@PathVariable("id") Long idAlu) {
		Student student = studentDAO.get(idAlu);
		if(student==null){
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
}
