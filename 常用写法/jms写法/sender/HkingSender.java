package com.hking.jms.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.hking.jms.creator.HkingCreator;

@Component(value="HkingSender")
public class HkingSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private HkingCreator hkingCreator;
	
	public void send() {
	    jmsTemplate.send("hking.queue", hkingCreator);
	}
}
