package com.cpandey.siexample;

import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;

import org.springframework.integration.xml.source.DomSourceFactory;
/**
 * @author Chandan Pandey
 *
 */
public class WsInboundService {
//refer WEB-INF/ws-inbound-config.xml for configurations
	public Source issueResponseFor(DOMSource request) {
		return new DomSourceFactory().createSource(
				"<testresponse xmlns=\"http://www.chandanpandey.com/testwebservice\">" +"response:"+
				request.getNode().getTextContent() + "</testresponse>");
	}
}
