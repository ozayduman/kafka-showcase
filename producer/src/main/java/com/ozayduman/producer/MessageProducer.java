package com.ozayduman.producer;

import com.ozayduman.message.Message;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Random;
import java.util.UUID;

@Service
public class MessageProducer {

    private static final String TOPIC_NAME  = "ozay";

    private final KafkaTemplate<String, Message> kafkaTemplate;
    private Random random;

    public MessageProducer(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.random = new Random();
    }

    @Scheduled(fixedRate = 1000 * 5)
    public void produceMessageWithFixedRate(){
        final var randomValue = String.valueOf(random.nextInt(10));
        final var message = new Message(randomValue, UUID.randomUUID().toString());
        final var future = kafkaTemplate.send(TOPIC_NAME, randomValue, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.err.println(throwable);
            }

            @Override
            public void onSuccess(SendResult<String, Message> stringMessageSendResult) {
                System.err.println(stringMessageSendResult.getProducerRecord().key() + "-" +stringMessageSendResult.getProducerRecord().value());
            }
        });
    }
}
