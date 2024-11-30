package sb.demo.ehcache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sb.demo.ehcache.entity.Student;
import sb.demo.ehcache.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/welcome")
	public String welcome() {
		System.out.println("welcome called for testing purpose....");
		return "Hello world";
	}
	
	@GetMapping(value = "/get-student")
	public ResponseEntity<Student> getStudent(@RequestParam Integer id) {
		
		 System.out.println("StudentService: getStudent() with id: "+ id);
		 Student allStudents = studentService.getStudent(id);
		 
		 return new ResponseEntity<Student>(allStudents, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-all-students")
	public ResponseEntity<List<Student>> getAllStudent() {
		
		 List<Student> allStudents = studentService.getAllStudents();
		 
		 return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/save-all-students")
	public ResponseEntity<String> saveAllStudent(@RequestBody List<Student> students) {
		 List<Student> savedStudents = studentService.saveStudents(students);
		 String msg = "";
		 if(null != savedStudents) {
			 msg = "All students saved successfully";
		 }
		 else {
			 msg = "Students not saved";
		 }
		 return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
