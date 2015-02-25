package com.cpandey.siexample.jmx;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

public class NotificationPublisher {
	private static final Logger LOGGER = Logger.getLogger(NotificationPublisher.class);
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-context.xml");
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			//do nothing
		}
		MessageChannel publishNotification = context.getBean("publishNotification", MessageChannel.class);
		publishNotification.send(MessageBuilder.withPayload("Sample Message").build());
		
		MessageChannel triggerOperationChannel = context.getBean("triggerOperationChannel", MessageChannel.class);
		triggerOperationChannel.send(MessageBuilder.withPayload("Trigger Method Adapter").build());
		
		MessageChannel requestOperationChannel = context.getBean("requestOperationChannel", MessageChannel.class);
		requestOperationChannel.send(MessageBuilder.withPayload("Trigger Method Gateway").build());
	
		MessageChannel input = context.getBean("controlBusChannel", MessageChannel.class);
		String controlMessage = "@controlBusTest.controlTestOperation()";
		LOGGER.info("Sending message: " + controlMessage);
		input.send(MessageBuilder.withPayload(controlMessage).build());
		
		try {
			Thread.sleep(180000);
		} catch (InterruptedException e) {
			//do nothing
		}
		context.stop();
	}
}
