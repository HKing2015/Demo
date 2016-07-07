package com.hking.jms.creator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component(value="HkingCreator")
public class HkingCreator implements MessageCreator { 
	@Override  
	public Message createMessage(Session paramSession) throws JMSException {
		String str = "jms测试信息";
	    return paramSession.createTextMessage(str);  
	}  
}
