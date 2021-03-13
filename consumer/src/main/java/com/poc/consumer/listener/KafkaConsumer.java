package com.poc.consumer.listener;

import com.poc.consumer.model.User;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer{
    
    @KafkaListener(topics="topic-a-string", groupId = "group_id")
    public void consume(String message){

        System.out.println("Consumed "+ message);
    }

    @KafkaListener(topics="topic-a", groupId = "group_json", containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(User message){
        
        System.out.println("Consumed json "+ message);
    }

}
