package com.cpandey.siexample.resequencer;

import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Completion strategy for re-sequencer.
 *
 * @author Chandan Pandey
 *
 */
public class ResequencerCompletionStrategy {
	//method should expect a java.util.List Object returning a Boolean value
	public boolean checkCompleteness(List<SyndEntry> messages) {
		if(messages!=null){
			if(messages.size()>5){
				return true;
			}
		}
		return false;
	}

}
