package com.cpandey.siexample.aggregator;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Correlates messages for aggregation based on the logic defined.
 *
 * @author Chandan Pandey
 *
 */
public class CorrelationStrategy {
	private static final Logger LOGGER = Logger.getLogger(CorrelationStrategy.class);
	
	//aggregator’s method should expect a Message<?> and	return an Object.
	public Object groupFeedsBasedOnCategory(Message<?> message) {
		//Which messages will be grouped in a bucket 
		//-say based on category, based on some ID etc.
		if(message!=null){
			SyndEntry entry = (SyndEntry)message.getPayload();
			List<SyndCategoryImpl> categories=entry.getCategories();
			if(categories!=null&&categories.size()>0){
				for (SyndCategoryImpl category: categories) {
					//for simplicity, lets consider the first category
					LOGGER.info("category "+category.getName());
					return category.getName();
				}
			}
		}
		return null;
	}
}
