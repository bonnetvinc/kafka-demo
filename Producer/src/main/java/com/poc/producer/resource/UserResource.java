package com.poc.producer.resource;

import com.poc.producer.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;


    @Autowired
    KafkaTemplate<String, String> kafkaTemplateString;
    
    public static final String TOPIC = "topic-a";

    public static final String TOPIC_STRING = "topic-a-string";
    
    @GetMapping("/publish/{name}")
    public String postUser(@PathVariable("name") final String name) {
      
        kafkaTemplate.send(TOPIC, new User(name, "IT", 6787678L) );

        return "Published user successfully";
    }

    @GetMapping("/publish/string/{name}")
    public String postString(@PathVariable("name") final String name) {
      
        kafkaTemplateString.send(TOPIC_STRING, name );

        return "Published string successfully";
    }
}