package com.hking.jms.listener;

import org.springframework.stereotype.Component;

@Component(value="hkingListener")
public class HkingListener {
	public void doTask(String str) {
		System.out.println("收到消息:" + str);
	}
}
