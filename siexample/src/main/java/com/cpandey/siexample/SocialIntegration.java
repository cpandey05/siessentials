
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * Showcase Twitter Integration
 *
 */
public final class SocialIntegration {
	private static final Logger LOGGER = Logger.getLogger(SocialIntegration.class);
	private SocialIntegration() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-twitter.xml");
		LOGGER.info("Context Started");
	}
}
