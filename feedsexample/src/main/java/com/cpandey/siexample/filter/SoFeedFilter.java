package com.cpandey.siexample.filter;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Decides based on criteria, whether all the components of the incomplete message 
 * has been assembled 
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedFilter {
	private static final Logger LOGGER = Logger.getLogger(SoFeedFilter.class);
	public boolean filterFeed(Message<SyndEntry> message){
		SyndEntry entry = message.getPayload();
		List<SyndCategoryImpl> categories=entry.getCategories();
		if(categories!=null&&categories.size()>0){
			for (SyndCategoryImpl category: categories) {
				if(category.getName().equalsIgnoreCase("java")){
					LOGGER.info("JAVA category feed");
					return true;
				}
			}
		}
		return false;
	}
}
