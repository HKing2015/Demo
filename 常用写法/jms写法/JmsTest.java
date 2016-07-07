package com.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hking.jms.sender.HkingSender;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:/spring/*.xml"})
public class JmsTest {
	@Autowired
	private HkingSender sender;
	@Test
	public void test() {
		sender.send();
	}
}
