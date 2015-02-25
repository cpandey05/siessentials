package com.cpandey.siexample.resequencer;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Correlation Strategy For Re-sequencer
 * @author Chandan Pandey
 *
 */
class ResequencerCorrelationStrategy {
	private static final Logger LOGGER = Logger.getLogger(ResequencerCorrelationStrategy.class);

	/**
	 * This method will group feeds based on category 
	 */
//	aggregator’s method should expect a Message<?> and	return an Object.
	public Object groupFeedsBasedOnPublishDate(Message<?> message) {
		if(message!=null){
			SyndEntry entry = (SyndEntry)message.getPayload();
			Calendar publishDate=Calendar.getInstance();
			publishDate.setTime(entry.getPublishedDate());
			LOGGER.info("DATE"+publishDate.get(Calendar.DATE));
			return publishDate.get(Calendar.DATE);
			
		}
		return null;
	}
}
