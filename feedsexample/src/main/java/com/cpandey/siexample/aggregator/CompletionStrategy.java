package com.cpandey.siexample.aggregator;

import java.util.List;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Decides based on criteria, whether all the components of the incomplete message 
 * has been assembled 
 *
 * @author Chandan Pandey
 *
 */
public class CompletionStrategy {
	private static final Logger LOGGER = Logger.getLogger(CompletionStrategy.class);
	//Completion strategy is used by aggregator to decide whether all components has
	//been aggregated or not method should expect a java.util.List 
	//Object returning a Boolean value
	public boolean checkCompleteness(List<SyndEntry> messages) {
		if(messages!=null){
			if(messages.size()>2){
				LOGGER.info("All components assembled, releasing aggregated message");
				return true;
			}
		}
		return false;
	}

}
