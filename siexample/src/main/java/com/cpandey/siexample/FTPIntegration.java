
package com.cpandey.siexample;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 * 
 * FTP integration support
 *
 */
public final class FTPIntegration {
	private static final Logger LOGGER = Logger.getLogger(FTPIntegration.class);
	private FTPIntegration() { }
	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-ftp.xml");
		LOGGER.info("Context Started");
	}
}
