package com.cpandey.siexample.splitter;

import java.util.List;

import org.springframework.messaging.Message;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
/**
 * @author Chandan Pandey
 *
 */
public class SoFeedSplitter {
	public List<SyndCategoryImpl> splitAndPublish(Message<SyndEntry> message) {
		SyndEntry syndEntry=message.getPayload();
		List<SyndCategoryImpl> categories= syndEntry.getCategories();
		return categories;
	}
}
