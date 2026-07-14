package com.niiran.engineering.service.impl;

import com.niiran.engineering.domain.Student;
import com.niiran.engineering.event.StudentEvent;
import com.niiran.engineering.producer.StudentProducer;
import com.niiran.engineering.repository.StudentRepository;
import com.niiran.engineering.service.StudentService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public StudentProducer studentProducer;


    @Override
    public Student saveStudent(Student student) {
        logger.info("Student details produces : {}",student);
        student.setStatus("ADMISSION");
        Student result = studentRepository.save(student);
        studentProducer.sendStudentEvent(new StudentEvent(result.getId(), result.getCourse(), result.getFee(), result.getStatus() ));
        return result;
    }


    @Override
    public void updateStudent(Long id, String status) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID not found in DB"));

        student.setStatus(status);
        studentRepository.save(student);
    }
}
