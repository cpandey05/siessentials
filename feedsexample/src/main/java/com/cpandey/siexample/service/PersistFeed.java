
package com.cpandey.siexample.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

import com.cpandey.siexample.pojo.FeedEntity;
import com.cpandey.siexample.pojo.SoFeed;

/**
 * Implementation for print feed gateway
 *
 * @author Chandan Pandey
 *
 */

@MessageEndpoint
public class PersistFeed {
	
	private static final Logger LOGGER = Logger.getLogger(PersistFeed.class);

	@Autowired FeedService feedService;
	@ServiceActivator
	public void persistFeedToDb(SoFeed feed) {
		//This will write to output channel of gateway
		//From there this will be picked by updating adapter
		feedService.createFeed(new FeedEntity(feed.getTitle()));
	}
	
	@ServiceActivator
	public void printFeed(FeedEntity feed) {
		//Print the feed fetched by retrieving adapter
		LOGGER.info("Feed Id"+feed.getId()+" Feed Title "+feed.getTitle());
	}
}
