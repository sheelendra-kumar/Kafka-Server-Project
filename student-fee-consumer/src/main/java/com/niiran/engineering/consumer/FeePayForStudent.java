package com.niiran.engineering.consumer;

import com.niiran.engineering.domain.StudentFee;
import com.niiran.engineering.event.FeeEvent;
import com.niiran.engineering.event.StudentEvent;
import com.niiran.engineering.producer.FeeProducer;
import com.niiran.engineering.repository.FeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FeePayForStudent {
    private static final Logger logger = LoggerFactory.getLogger(FeePayForStudent.class);
    @Autowired
    public FeeProducer feeProducer;

    @Autowired
    public FeeRepository feeRepository;
    @KafkaListener(topics ="student-topic", groupId = "fee-group")
    public void peyFeeStudent(StudentEvent studentEvent){
        logger.info("STUDENT FEE CONSUME SUCCESSFULLY :| {} ",studentEvent);

        StudentFee studentFee = new StudentFee();
        studentFee.setStudentId(studentEvent.getStudentId());
        studentFee.setCourse(studentEvent.getCourse());
        studentFee.setAmount(studentEvent.getAmount());
        studentFee.setStatus(studentEvent.getStatus());

        //Fee Pey

        if(studentEvent.getAmount() < 100000){
            studentFee.setStatus("SUCCESS");
            feeRepository.save(studentFee);
            feeProducer.sendFeeStudent(new FeeEvent(studentEvent.getStudentId(), studentEvent.getCourse(), studentEvent.getAmount(), studentFee.getStatus()));
        }else {
            studentFee.setStatus("FAILED");
            feeRepository.save(studentFee);
            feeProducer.sendFeeStudent(new FeeEvent(studentEvent.getStudentId(), studentEvent.getCourse(), studentEvent.getAmount(), studentEvent.getStatus()));
        }
    }
}
