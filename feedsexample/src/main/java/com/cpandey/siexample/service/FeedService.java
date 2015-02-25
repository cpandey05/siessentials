
package com.cpandey.siexample.service;

/**
 * This is gateway, definition in spring-integration-context.xml
 *
 * @author Chandan Pandey
 *
 */
import java.util.List;

import com.cpandey.siexample.pojo.FeedEntity;


public interface FeedService {

	FeedEntity createFeed(FeedEntity feed);
	List<FeedEntity> readAllFeed();
}
