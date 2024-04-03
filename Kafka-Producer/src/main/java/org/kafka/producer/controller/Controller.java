package org.kafka.producer.controller;

import org.kafka.producer.entity.KafkaMessage;
import org.kafka.producer.service.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.backoff.Sleeper;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Timer;

@RestController
@RequestMapping("/send")
public class Controller {

    Logger log = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private KafkaProducer sender;

    @PostMapping(path = "/test1")
    private ResponseEntity<?> sendMessage(@RequestBody KafkaMessage data) {

            sender.SendKafkaMessage(data.getMessage());
            log.info("I am ahead of sending");
            return ResponseEntity.ok("MESSAGE PUBLISHED SUCCESSFULLY");
    }

    @GetMapping(path = "/show")
    private String showMessage(){
            return "I am working";
        }


}
