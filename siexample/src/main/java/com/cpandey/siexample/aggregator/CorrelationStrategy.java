package com.cpandey.siexample.aggregator;

/**
 * Correlation Strategy, part of Aggregator.
 *
 * @author Chandan Pandey
 *
 */
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;

public class CorrelationStrategy {
	private static final Logger LOGGER = Logger.getLogger(CorrelationStrategy.class);
	//	aggregator’s method should expect a Message<?> and	return an Object.
	public Object groupFeedsBasedOnCategory(Message<?> message) {
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
