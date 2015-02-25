package com.cpandey.siexample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.integration.test.matcher.PayloadMatcher.hasPayload;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.transformer.MessageTransformationException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.MessagingException;
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
public class TestSoDBFeedTransformer {
	@Autowired
	MessageChannel filteredFeedChannel;
	
	@Autowired
	QueueChannel transformedChannel;
	
	@Test
	public void messageIsConvertedToEntity() {
		SyndEntry entry =new SyndEntryImpl();
		entry.setTitle("Test");
		SyndContent content=new SyndContentImpl();
		content.setValue("TestValue");
		entry.setDescription(content);
		List<SyndCategoryImpl> catList=new ArrayList<SyndCategoryImpl>();
		entry.setCategories(catList);
		entry.setLink("TestLink");
		entry.setAuthor("TestAuthor");
		
		
		SoFeed expectedSoFeed=new SoFeed();
		expectedSoFeed.setTitle(entry.getTitle());
		expectedSoFeed.setDescription(entry.getDescription().getValue());
		expectedSoFeed.setCategories(entry.getCategories());
		expectedSoFeed.setLink(entry.getLink());
		expectedSoFeed.setAuthor(entry.getAuthor());
		
		
		
		Message<SyndEntry> message = MessageBuilder.withPayload(entry).build();
		filteredFeedChannel.send(message);
		Message<?> outMessage = transformedChannel.receive(0);
		SoFeed soFeedReceived=(SoFeed)outMessage.getPayload();
		assertNotNull(outMessage);
		assertThat(outMessage, hasPayload(soFeedReceived));
		outMessage = transformedChannel.receive(0);
		assertNull("Only one message expected", outMessage);
	}
	
	@Test(expected = MessageTransformationException.class)
	public void errorReportedWhenPayloadIsWrong() {
		Message<String> message = MessageBuilder.withPayload("this should fail").build();
		filteredFeedChannel.send(message);
	}

}
