package com.cpandey.siexample.jmx;

import org.apache.log4j.Logger;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

@Component
public class ControlBusTest {
	private static final Logger LOGGER = Logger.getLogger(ControlBusTest.class);
	@ManagedOperation
	public void controlTestOperation() {
		LOGGER.info("controlTestOperation");
	}
}
