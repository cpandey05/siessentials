
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * This will execute examples for common feed adapter, service activator, filter, transformer, router, JMS, Mail and Database
 *
 */
public final class EndpointsMailJmsDb {
	private static final Logger LOGGER = Logger.getLogger(EndpointsMailJmsDb.class);
	private EndpointsMailJmsDb() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-endpoints.xml");
		LOGGER.info("Context Started");
	}
}
