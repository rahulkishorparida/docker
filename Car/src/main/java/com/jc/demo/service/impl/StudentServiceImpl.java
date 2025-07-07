package com.jc.demo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.demo.model.Student;
import com.jc.demo.repo.StudentRepo;
import com.jc.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Boolean saveStudent(Student student) {
        return studentRepo.save(student) != null;
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Boolean deletebyId(String id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student findbyId(String id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public void clearAll() {
        studentRepo.deleteAll();
    }
}
