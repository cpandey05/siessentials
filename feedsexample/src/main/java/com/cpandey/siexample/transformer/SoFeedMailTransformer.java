package com.cpandey.siexample.transformer;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.messaging.Message;

import com.cpandey.siexample.pojo.SoFeed;
import com.sun.syndication.feed.synd.SyndEntry;
/**
 * Transform Feed into MailMessage which can be send as email 
 *
 * @author Chandan Pandey
 *
 */
public class SoFeedMailTransformer {
	private static final Logger LOGGER = Logger.getLogger(SoFeedMailTransformer.class);

	public MailMessage transformFeed(Message<SyndEntry> message){
		SyndEntry entry = message.getPayload();
		SoFeed soFeed=new SoFeed();
		soFeed.setTitle(entry.getTitle());
		soFeed.setDescription(entry.getDescription().getValue());
		soFeed.setCategories(entry.getCategories());
		soFeed.setLink(entry.getLink());
		soFeed.setAuthor(entry.getAuthor());
		
		//For Mail return MailMessage
		MailMessage msg = new SimpleMailMessage();
		msg.setTo("emailaddress");
		msg.setFrom("emailaddress");
		msg.setSubject("Subject");
		msg.setSentDate(new Date());
		msg.setText("Mail Text");
		LOGGER.info("Mail Message"+soFeed.getTitle());
		
	   return msg; 	
	}
}
