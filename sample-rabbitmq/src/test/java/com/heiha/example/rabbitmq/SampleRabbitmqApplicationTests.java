package com.heiha.example.rabbitmq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.impl.AMQImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleRabbitmqApplication.class)
public class SampleRabbitmqApplicationTests {
	@Autowired
	private Producer producer;

	@Test
	public void contextLoads() {
		for (int i = 0; i < 10; i++) {
			producer.send("heiha.test.queue", "Text " + i);
		}
	}

}
