package com.cpandey.siexample.aggregator;

import java.util.List;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Decides when all the components of the incomplete message has been delivered
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedAggregator {
	private static final Logger LOGGER = Logger.getLogger(SoFeedAggregator.class);
	public List<SyndEntry> aggregateAndPublish( List<SyndEntry> messages) {
		LOGGER.info("SoFeedAggregator -Aggregation complete	");
		return messages;
	}
}
