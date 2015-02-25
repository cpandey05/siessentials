package com.cpandey.siexample;

import org.apache.log4j.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author Chandan Pandey
 *
 */
public class HttpOutBoundClient {
	
	private static Logger logger = Logger.getLogger(HttpOutBoundClient.class);

	public static void main(String[] args) {
		//refer WEB-INF/http-inbound-config.xml for further configuration 
		ApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/integration/http-outbound-config.xml");
		OutboundRequestGateway outboundRequestGateway = context.getBean("outboundRequestGateway", OutboundRequestGateway.class);
		String reply = outboundRequestGateway.echoResponse("Hello");  
		logger.info("OutboundRequestGateway");
		logger.info("OutboundRequestGateway Replied with: " + reply);
	}

}
