package com.niiran.engineering.producer;

import com.niiran.engineering.event.FeeEvent;
import com.niiran.engineering.event.StudentEvent;
import com.niiran.engineering.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentConsumer {
    private static final Logger logger = LoggerFactory.getLogger(StudentConsumer.class);

    @Autowired
    public StudentService studentService;

    @KafkaListener(topics ="fee-topic", groupId = "fee-group")
    public void consumeFeeEvent(FeeEvent feeEvent) {
        logger.info("PAYMENT EVENT CONSUME SUCCESSFULLY : {}", feeEvent);
        if ("SUCCESS".equals(feeEvent.getStatus())) {
            studentService.updateStudent(feeEvent.getStudentId(), "COMPLETE");
        } else {
            studentService.updateStudent(feeEvent.getStudentId(), "CANCEL");
        }
    }
}
