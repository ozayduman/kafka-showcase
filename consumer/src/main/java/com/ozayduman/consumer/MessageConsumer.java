package com.ozayduman.consumer;

import com.ozayduman.message.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {
    private static final String TOPIC_NAME="ozay";

    @KafkaListener(topics = {TOPIC_NAME})
    public void consume(Message message) {
        log.info("Consume message from Kafka topic: {}. Key: {} Value: {}", TOPIC_NAME, message.getUuid(), message);
        System.err.println(String.format("Consume message from topic %s with uuid: %s and content: %s",TOPIC_NAME, message.getUuid(), message));
    }
}
