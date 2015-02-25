package com.cpandey.siexample.aggregator;

/**
 * Aggregator Example.
 *
 * @author Chandan Pandey
 *
 */
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndEntry;

public class SoFeedAggregator {
	private static final Logger LOGGER = Logger.getLogger(SoFeedAggregator.class);
	public List<SyndEntry> aggregateAndPublish( List<SyndEntry> messages) {
		LOGGER.info("Aggregate");
		return messages;
	}
}
