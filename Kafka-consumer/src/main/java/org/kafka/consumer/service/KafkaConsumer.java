//package org.kafka.consumer.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.Model;
//
//import java.util.*;
//
//@Service
//public class KafkaConsumer {
//
//    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
//
//    @Value("${kafka.topic.name}")
//    private String topic;
//
//    @Autowired
//    private KafkaTemplate<String, Object> template;
//
//    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.groupId.name}")
//    public void consume(String data){
//        logger.info("Received message: " + data);
//
//    }
//
//}
