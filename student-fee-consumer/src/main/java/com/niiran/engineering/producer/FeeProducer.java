package com.niiran.engineering.producer;

import com.niiran.engineering.event.FeeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class FeeProducer {

    private static final Logger logger = LoggerFactory.getLogger(FeeProducer.class);

    private final KafkaTemplate<String, FeeEvent> kafkaTemplate;

    public FeeProducer(KafkaTemplate<String, FeeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendFeeStudent(FeeEvent feeEvent) {

        logger.info("INIT | Sending fee event | studentId={}", feeEvent.getStudentId());

        kafkaTemplate.send("fee-topic", feeEvent.getStudentId().toString(), feeEvent)
                .whenComplete((result, ex) -> {

                    if (ex == null) {
                        System.out.println("Message Sent Successfully");
                    } else {
                        System.out.println("Error while sending message");
                    }

                });
    }
}