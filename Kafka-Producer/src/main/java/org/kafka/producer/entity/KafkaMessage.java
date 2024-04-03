package org.kafka.producer.entity;

import lombok.Data;

@Data
public class KafkaMessage {

    private String message;

    private String topic;
}
