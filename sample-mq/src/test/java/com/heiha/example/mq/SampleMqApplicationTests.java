package com.heiha.example.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SampleMqApplication.class)
public class SampleMqApplicationTests {
	@Autowired
	private Producer producer;

	@Test
	public void test() {
		Destination destination = new ActiveMQQueue("heiha.test.queue");
		for (int i = 0; i < 30; i++) {
			producer.send(destination, "Text - " + i);
		}
	}
}