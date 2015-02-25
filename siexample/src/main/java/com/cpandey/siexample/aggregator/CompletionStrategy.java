package com.cpandey.siexample.aggregator;

/**
 * Completion Strategy, part of aggregator
 *
 * @author Chandan Pandey
 *
 */
import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;

public class CompletionStrategy {
	//method should expect a java.util.List Object returning a Boolean value
	public boolean checkCompleteness(List<SyndEntry> messages) {
		if(messages!=null){
			if(messages.size()>2){
				return true;
			}
		}
		return false;
	}

}
