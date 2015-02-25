package com.cpandey.siexample.transformer;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.cpandey.siexample.pojo.SoFeed;
import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Transform Feed into entity which can be written to database
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedDbTransformer {
	private static final Logger LOGGER = Logger.getLogger(SoFeedDbTransformer.class);

	public SoFeed transformFeed(Message<SyndEntry> message){
		SyndEntry entry = message.getPayload();
		SoFeed soFeed=new SoFeed();
		soFeed.setTitle(entry.getTitle());
		soFeed.setDescription(entry.getDescription().getValue());
		soFeed.setCategories(entry.getCategories());
		soFeed.setLink(entry.getLink());
		soFeed.setAuthor(entry.getAuthor());
		LOGGER.info("JDBC :: "+soFeed.getTitle());
		return soFeed;
	}
}
