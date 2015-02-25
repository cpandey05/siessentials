
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * Showcase Aggregator and it's related components
 *
 */
public final class Aggregator {
	private static final Logger LOGGER = Logger.getLogger(Aggregator.class);
	private Aggregator() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-aggregator.xml");
		LOGGER.info("Context Started");
	}
}
