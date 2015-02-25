package com.cpandey.siexample;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeader;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeaderKey;
import static org.springframework.integration.test.matcher.PayloadMatcher.hasPayload;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cpandey.siexample.pojo.SoFeed;
import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;

@ContextConfiguration	// default context name is <ClassName>-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSplitter {
	@Autowired
	MessageChannel filteredFeedChannel;
	
	@Autowired
	QueueChannel splitFeedOutputChannel;
	
	
	@Test
	public void javaMessagePassedThrough() {
		SyndEntry entry =new SyndEntryImpl();
		entry.setTitle("Test");
		SyndContent content=new SyndContentImpl();
		content.setValue("TestValue");
		entry.setDescription(content);
		List<SyndCategoryImpl> catList=new ArrayList<SyndCategoryImpl>();
		SyndCategoryImpl category1=new SyndCategoryImpl();
		category1.setName("java");
		category1.setTaxonomyUri("");
		SyndCategoryImpl category2=new SyndCategoryImpl();
		category2.setName("java");
		category2.setTaxonomyUri("");
		catList.add(category1);
		catList.add(category2);
		entry.setCategories(catList);
		entry.setLink("TestLink");
		entry.setAuthor("TestAuthor");
		
		Message<SyndEntry> message = MessageBuilder.withPayload(entry).build();
		filteredFeedChannel.send(message);
		Message<?> outMessage1 = splitFeedOutputChannel.receive(0);
		Message<?> outMessage2 = splitFeedOutputChannel.receive(0);
		assertNotNull("Expected an output message", outMessage1);
		assertNotNull("Expected an output message", outMessage2);
		assertThat(outMessage1, hasPayload(category1));
		assertThat(outMessage2, hasPayload(category2));
	}

}
