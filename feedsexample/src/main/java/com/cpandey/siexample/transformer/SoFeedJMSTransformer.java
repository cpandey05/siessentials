package com.cpandey.siexample.transformer;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.cpandey.siexample.pojo.SoFeed;
import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Transform Feed into String which can be written to JMS queue
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedJMSTransformer {
	private static final Logger LOGGER = Logger.getLogger(SoFeedJMSTransformer.class);
	
	public String transformFeed(Message<SyndEntry> message){
		SyndEntry entry = message.getPayload();
		SoFeed soFeed=new SoFeed();
		soFeed.setTitle(entry.getTitle());
		soFeed.setDescription(entry.getDescription().getValue());
		soFeed.setCategories(entry.getCategories());
		soFeed.setLink(entry.getLink());
		soFeed.setAuthor(entry.getAuthor());
		//For JSM , return String 
		LOGGER.info("JMS"+soFeed.getTitle());
		return soFeed.toString();
	}
}
