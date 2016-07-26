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

@ContextConfiguration(locations = {"classpath*:**/TestFilter-context.xml"})	// default context name is <ClassName>-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
public class TestFilter {
	@Autowired
	MessageChannel fetchedFeedChannel;
	
	@Autowired
	QueueChannel filteredFeedChannel;
	
	
	@Test
	public void javaMessagePassedThrough() {
		SyndEntry entry =new SyndEntryImpl();
		entry.setTitle("Test");
		SyndContent content=new SyndContentImpl();
		content.setValue("TestValue");
		entry.setDescription(content);
		List<SyndCategoryImpl> catList=new ArrayList<SyndCategoryImpl>();
		SyndCategoryImpl category=new SyndCategoryImpl();
		category.setName("java");
		catList.add(category);
		entry.setCategories(catList);
		entry.setLink("TestLink");
		entry.setAuthor("TestAuthor");
		
		Message<SyndEntry> message = MessageBuilder.withPayload(entry).build();
		fetchedFeedChannel.send(message);
		Message<?> outMessage = filteredFeedChannel.receive(0);
		assertNotNull("Expected an output message", outMessage);
		assertThat(outMessage, hasPayload(entry));
	}

	@Test
	public void nonJavaMessageDropped() {
		SyndEntry entry =new SyndEntryImpl();
		entry.setTitle("Test");
		SyndContent content=new SyndContentImpl();
		content.setValue("TestValue");
		entry.setDescription(content);
		List<SyndCategoryImpl> catList=new ArrayList<SyndCategoryImpl>();
		SyndCategoryImpl category=new SyndCategoryImpl();
		category.setName("nonjava");
		catList.add(category);
		entry.setCategories(catList);
		entry.setLink("TestLink");
		entry.setAuthor("TestAuthor");
		
		Message<SyndEntry> message = MessageBuilder.withPayload(entry).build();
		fetchedFeedChannel.send(message);
		Message<?> outMessage = filteredFeedChannel.receive(0);
		assertNull("Expected no output message", outMessage);
	}
}
