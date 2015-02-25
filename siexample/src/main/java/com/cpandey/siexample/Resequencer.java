
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * Showcase Resequencer and it's related components
 *
 */
public final class Resequencer {
	private static final Logger LOGGER = Logger.getLogger(Resequencer.class);
	private Resequencer() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-resequencer.xml");
		LOGGER.info("Context Started");
	}
}
