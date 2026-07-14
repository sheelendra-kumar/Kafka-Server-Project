package com.niiran.engineering.producer;

import com.niiran.engineering.event.StudentEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class StudentProducer {

    private static final Logger logger = LoggerFactory.getLogger(StudentProducer.class);

    @Autowired
    private KafkaTemplate<String, StudentEvent> kafkaTemplate;

    private final MessageChannel messageChannel;

    public StudentProducer(MessageChannel messageChannel) {
        this.messageChannel = messageChannel;
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void sendStudentEvent(StudentEvent studentEvent){
        messageChannel.send(MessageBuilder.withPayload(studentEvent).build());



        /*
        logger.info("INIT | Sending Student event id={}", studentEvent.getStudentId());

        ListenableFuture<SendResult<String, StudentEvent>> future =
                kafkaTemplate.send("student-topic", studentEvent);

        future.addCallback(result -> {
            if(result != null){
                logger.info("SUCCESS | topic={}, partition={}, offset={}, studentId={}",
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset(),
                        studentEvent.getStudentId());
            }
        }, ex -> {
            logger.error("CANCEL | studentId={} error={}",
                    studentEvent.getStudentId(), ex.getMessage());
        });
         */
    }
}

