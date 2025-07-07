package com.jc.demo.controller;

import com.jc.demo.model.Student;
import com.jc.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
//swagger
    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        boolean saved = studentService.saveStudent(student);
        return saved ? ResponseEntity.ok("Student saved successfully.")
                     : ResponseEntity.status(500).body("Failed to save student.");
    }

    // READ ALL
    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        Student student = studentService.findbyId(id);
        return student != null ? ResponseEntity.ok(student)
                               : ResponseEntity.status(404).body("Student not found.");
    }

    // DELETE BY ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        boolean deleted = studentService.deletebyId(id);
        return deleted ? ResponseEntity.ok("Student deleted successfully.")
                       : ResponseEntity.status(404).body("Student not found.");
    }

    // DELETE ALL
    @DeleteMapping("/clear")
    public ResponseEntity<String> clearAllStudents() {
        studentService.clearAll();
        return ResponseEntity.ok("All students deleted.");
    }
}
