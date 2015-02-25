
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * Showcase File integration support
 *
 */
public final class FileIntegration {
	private static final Logger LOGGER = Logger.getLogger(FileIntegration.class);
	private FileIntegration() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-file.xml");
		LOGGER.info("Context Started");
	}
}
