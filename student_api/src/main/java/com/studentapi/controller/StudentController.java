package com.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapi.model.Student;
import com.studentapi.services.StudentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudentDetails(student);
	}
//	@GetMapping("/home")
//	public String home() {
//		return "Home";
//	}
	
	@GetMapping("/getStudents")
	public List<Student> displayStudents(){
		return studentService.getStudents();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
}
