
package com.cpandey.siexample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Starts the Spring Context and will initialize the Spring Integration routes.
 *
 * @author Chandan Pandey
 *
 */
public final class FeedsExample {
	private FeedsExample() { }

	public static void main(final String... args) {
		final AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/spring-integration-context.xml");
	}
}
