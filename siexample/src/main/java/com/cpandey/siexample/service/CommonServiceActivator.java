
package com.cpandey.siexample.service;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;

/**
 * A common service activator class which have utility methods to cater to many example scenarios.
 *
 * @author Chandan Pandey
 *
 */
@MessageEndpoint
public class CommonServiceActivator {
	private static final Logger LOGGER = Logger.getLogger(CommonServiceActivator.class);

	public void printAggregatedFeed(Message<List<SyndEntry>> aggregatedMessage ) {
		if(aggregatedMessage!=null){
			List<SyndEntry> syndEntries=aggregatedMessage.getPayload();
			LOGGER.info(syndEntries.size());
		}
	}
	
	public void printResequencedFeed(List<SyndEntry> aggregatedMessage ) {
		if(aggregatedMessage!=null){
			LOGGER.info(aggregatedMessage.size());
		}
	}
	public void chainedFeed(Message<?> message) {
		MessageHeaders headers=message.getHeaders();
		
		if(headers!=null){
			Iterator<String> itr=headers.keySet().iterator();
			while (itr.hasNext()) {
				LOGGER.info("Header KEY"+itr.next());
			}
		}
	}
	public void printPayLoad(Message<?> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
		
	}
	public void printSplitMessage(Message<SyndCategoryImpl> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
		
	}
	public void printFileName(Message<File> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	
	public void echoJmsMessageInput(Message<?> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	

	public void echoMessageInput(Message<?> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	public void echoMessageOutput(Message<?> message) {
		if(message!=null){
			LOGGER.info(message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	public void echoTweets(Message<?> message) {
		if(message!=null){
			LOGGER.info("Twitter message :: "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	public void echoSearchedTweets(Message<?> message) {
		if(message!=null){
			LOGGER.info("Twitter searched message :: "+message.getPayload());
		}else{
			LOGGER.info("Message is null");
		}
	}	
	public void printTailedMessage(Message<?> message) {
		if(message!=null){
			LOGGER.info("Tailed message :: "+message.getPayload());
		}else{
			LOGGER.info("Tailed message is null");
		}
	}
	public void printSqlResult(Message<?> message) {
		if(message!=null){
			LOGGER.info("SQL Result :: "+message.getPayload());
		}else{
			LOGGER.info("SQL Result :: null");
		}
	}
	public void printSqlInsertResult(Message<?> message) {
		if(message!=null){
			LOGGER.info("SQL Insert Result :: "+message.getPayload());
		}else{
			LOGGER.info("SQL Insert Result :: null");
		}
	}
	
	
}
