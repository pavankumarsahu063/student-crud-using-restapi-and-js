package com.studentapi.reposistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapi.model.Student;


@Repository
public interface StudentReposistory extends JpaRepository<Student, Integer>{

}
