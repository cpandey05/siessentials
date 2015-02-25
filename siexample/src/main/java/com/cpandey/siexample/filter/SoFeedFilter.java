package com.cpandey.siexample.filter;

import java.util.List;

import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
/**
 * A filter component.
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedFilter {
	public boolean filterFeed(Message<SyndEntry> message){
		SyndEntry entry = message.getPayload();
		List<SyndCategoryImpl> categories=entry.getCategories();
		if(categories!=null&&categories.size()>0){
			for (SyndCategoryImpl category: categories) {
				if(category.getName().equalsIgnoreCase("java")){
					return true;
				}
				
			}
		}
		return false;
	}
}
