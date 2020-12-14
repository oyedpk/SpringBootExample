package com.example.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class KafkaExampleApplication implements ApplicationRunner {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	public static void main(String[] args) {
		SpringApplication.run(KafkaExampleApplication.class, args);
	}

	public void sendMessage(String msg) {
		kafkaTemplate.send("kafkaExample",msg);
	}

	@KafkaListener(topics = "kafkaExample", groupId= "group-id")
	public void listen(String message) {
		System.out.println("Received message in group - group-id " + message);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		sendMessage("Hi welcome to spring Apache kafke");
	}

}
