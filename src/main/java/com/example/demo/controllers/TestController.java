package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String msg) {
        kafkaTemplate.send("mgi", msg);
    }
    @RequestMapping("/send")
    public String index() {
        sendMessage("rahulbats");
        return "Greetings from Spring Boot!";
    }
}
