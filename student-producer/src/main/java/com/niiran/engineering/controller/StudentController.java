package com.niiran.engineering.controller;

import com.niiran.engineering.domain.Student;
import com.niiran.engineering.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    public StudentService studentService;
    @PostMapping("/create")
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        logger.info("REST Request to save :", student);
        Student result = studentService.saveStudent(student);
        return ResponseEntity.ok().body(result);
    }
}
