package com.kafka.consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.consumer.DTO.BankAccountDTO;

@Service
public class BankAccountConsumer {
	@Value(value = "${topic.name}")
	private String topic;

	@Value(value = "${spring.kafka.group-id}")
	private String groupId;
	
	private static final Logger logger = LoggerFactory.getLogger(BankAccountConsumer.class);
	
	@KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "bankAccountKafkaListenerContainerFactory")
	public void listenTopicAccountBank(ConsumerRecord<String, BankAccountDTO> record) {
//		System.out.println(record);
//		System.out.println("Value: " + record.value());
		logger.info("Received Message" + record.partition());
		logger.info("Received Message" + record.value());
	}
}
