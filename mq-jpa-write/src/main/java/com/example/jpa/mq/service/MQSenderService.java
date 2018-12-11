package com.example.jpa.mq.service;

import org.springframework.amqp.core.AmqpTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.jpa.entity.BaseEntity;
import com.example.jpa.entity.MQEntity;


@Component
public class MQSenderService<T extends MQEntity<? extends BaseEntity>> {
	@Autowired
	private AmqpTemplate mqTemplate;


	
	public void send(T t) {
		mqTemplate.convertAndSend("hello",t.toString());
	}
}
