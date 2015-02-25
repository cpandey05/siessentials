package com.cpandey.siexample.splitter;

import java.util.List;

import com.sun.syndication.feed.synd.SyndEntry;

/**
 * Splitter, receives a list of messages and after splitting it, passes on 
 * one message at a time to next channel
 *
 * @author Chandan Pandey
 *
 */

public class SoFeedSplitter {
	public List<SyndEntry> splitAndPublish(List<SyndEntry> message) {
		//Return one message from list at a time -this will be picked up by the processor
		return message;
	}
}
