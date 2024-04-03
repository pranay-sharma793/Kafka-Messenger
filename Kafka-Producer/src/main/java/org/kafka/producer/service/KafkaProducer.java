package org.kafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@EnableAsync
public class KafkaProducer {

    @Value("${kafka.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Async
    public void SendKafkaMessage(String data){

        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                long time = Instant.now().toEpochMilli();
                CompletableFuture<SendResult<String, Object>> result = template.send(topic, data + " : " + time);
                System.out.println(result.get().toString());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
