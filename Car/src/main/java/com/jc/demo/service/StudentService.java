package com.jc.demo.service;

import java.util.List;

import com.jc.demo.model.Student;

public interface StudentService {
	
	
	public Boolean saveStudent(Student student);
	public List<Student> findAll();
	public Boolean deletebyId(String id);
	public Student findbyId(String id);
	public void clearAll();

}
