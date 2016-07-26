package com.cpandey.siexample;

import static org.junit.Assert.assertThat;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeader;
import static org.springframework.integration.test.matcher.HeaderMatcher.hasHeaderKey;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = {"classpath*:**/TestSoHeaderAddition-context.xml"})	// default context name is <ClassName>-context.xml
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSoHeaderAddition {
	@Autowired
	MessageChannel filteredFeedChannel;
	
	@Autowired
	QueueChannel transformedChannel;
	
	@Test
	public void headerIsAddedToEntity() {
		Message<String> message = MessageBuilder.withPayload("testheader").build();
		filteredFeedChannel.send(message);
		Message<?> outMessage = transformedChannel.receive(0);
		assertThat(outMessage, hasHeaderKey("testHeaderKey1"));
		assertThat(outMessage, hasHeader("testHeaderKey1", "testHeaderValue1"));
	}
}
