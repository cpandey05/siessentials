
package com.cpandey.siexample.service;


import java.util.List;

import com.cpandey.siexample.pojo.FeedEntity;
/**
 * @author Chandan Pandey
 *
 */

public interface FeedService {

	FeedEntity createFeed(FeedEntity feed);
	List<FeedEntity> readAllFeed();
	

}
