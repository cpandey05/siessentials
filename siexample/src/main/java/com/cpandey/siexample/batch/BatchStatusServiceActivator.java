package com.cpandey.siexample.batch;

/**
 * Service hooked to Batch Status.
 *
 * @author Chandan Pandey
 *
 */
import org.apache.log4j.Logger;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;


@MessageEndpoint
public class BatchStatusServiceActivator {
	private static final Logger LOGGER = Logger.getLogger(BatchStatusServiceActivator.class);
	public void printStatus(Message<JobExecution> status ) {
		if(status!=null){
			LOGGER.info("Status :: "+status.getPayload().toString());
		}
	}
}
