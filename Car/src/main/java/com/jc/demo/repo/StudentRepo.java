package com.jc.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jc.demo.model.Student;

public interface StudentRepo extends JpaRepository<Student, String>{

}
