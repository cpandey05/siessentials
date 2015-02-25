package com.cpandey.siexample.service;
/**
 *A common service activator, used by multiple components for testing code 
 *
 * @author Chandan Pandey
 *
 */
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.history.MessageHistory;
import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndEntry;


@MessageEndpoint
public class CommonServiceActivator {
	private static final Logger LOGGER = Logger.getLogger(CommonServiceActivator.class);
	
	public void printAggregatedFeed(Message<List<SyndEntry>> aggregatedMessage ) {
		if(aggregatedMessage!=null){
			List<SyndEntry> syndEntries=aggregatedMessage.getPayload();
			LOGGER.info("Aggregated entry size "+syndEntries.size());
		}
	}
	
	public void printPayLoad(Message<?> message) {
		if(message!=null){
			LOGGER.info("Message Payload "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
		
	}
	
	public void echoMessageInput(Message<?> message) {
		if(message!=null){
			LOGGER.info("Message Input "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	public void echoJmsMessageInput(Message<?> message) {
		if(message!=null){
			LOGGER.info("JMS Input "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	
	
	public void attributePolled(Message<?> message) {
		if(message!=null){
			LOGGER.info("Polled attribute"+message.getPayload());
			//Print headers
			Iterator<Properties> messageHistoryItr =message.getHeaders().get(MessageHistory.HEADER_NAME,MessageHistory.class).iterator();
			while(messageHistoryItr.hasNext()) {
				Properties properties = messageHistoryItr.next();
				LOGGER.info(properties);
			}
		}else{
			LOGGER.info("Message is null");
		}
	}
	public void mbeanTreePolled(Message<?> message) {
		if(message!=null){
			LOGGER.info("JMS Input "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}
	public void operationInvokedGateway(Message<?> message) {
		if(message!=null){
			LOGGER.info("JMS Input "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
}
