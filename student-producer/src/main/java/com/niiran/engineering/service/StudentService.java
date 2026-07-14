package com.niiran.engineering.service;

import com.niiran.engineering.domain.Student;

public interface StudentService {
    Student saveStudent(Student student);
    void updateStudent(Long id, String status);
}
