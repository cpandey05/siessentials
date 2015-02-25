package com.cpandey.siexample.jmx;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NotificationListener {
	public static void main(String[] args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-context.xml");
		try {
			Thread.sleep(300000);
		} catch (InterruptedException e) {
			//do nothing
		}
		context.stop();
		
	}
}
