package com.studentapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapi.model.Student;
import com.studentapi.reposistory.StudentReposistory;

@Service
public class StudentService {
		
	@Autowired
	private StudentReposistory studentReposistory;
	
	public Student addStudentDetails(Student student) {
		
		return studentReposistory.save(student);
		
	}
	
	public List<Student> getStudents(){
		return studentReposistory.findAll();
	}
	
	public void deleteStudent(int id) {
		studentReposistory.deleteById(id);
	}
}
