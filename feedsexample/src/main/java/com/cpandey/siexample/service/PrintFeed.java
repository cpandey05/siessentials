package com.cpandey.siexample.service;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Utility class to print message
 *
 * @author Chandan Pandey
 *
 */

@MessageEndpoint
public class PrintFeed {

	private static final Logger LOGGER = Logger.getLogger(PrintFeed.class);

	@ServiceActivator
	public String upperCase(String input) {
		LOGGER.info("Converted to upper case "+input.toUpperCase());
		return "Converted to upper case "+input.toUpperCase();
	}
}
