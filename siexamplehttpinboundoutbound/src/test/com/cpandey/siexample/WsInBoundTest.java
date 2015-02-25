package com.cpandey.siexample;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.xml.transform.Source;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

public class WsInBoundTest {

	private static Logger logger = Logger.getLogger(WsInBoundTest.class);
	private static final String WS_URI = "http://localhost:8080/siexamplewsinbound/testwsservice";
	private final WebServiceTemplate template = new WebServiceTemplate();

	@Test
	public void testWebServiceRequestAndResponse() {
		StringResult result = new StringResult();
		Source payload = new StringSource(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<testresponse xmlns=\"http://www.chandanpandey.com/testwebservice\">testwsinbound</testresponse>");

		template.sendSourceAndReceiveToResult(WS_URI, payload, result);
		logger.info("RESULT: " + result.toString());
		assertThat(result.toString(), equalTo(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
				"<testresponse xmlns=\"http://www.chandanpandey.com/testwebservice\">response:testwsinbound</testresponse>"));
	}
}
