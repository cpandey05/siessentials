package com.cpandey.siexample;


import java.io.File;

import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.messaging.Message;

/**
 * Test In bound File Manager.
 *
 * @author Chandan Pandey
 *
 */
public class InboundFileAdapter {
	// set the directory from where the files need to be picked up
	File directory = new File("C:\\Chandan\\Projects\\inputfolderforsi");
	public void startFileAdatper() {
		FileReadingMessageSource fileReadingMessageSource = new FileReadingMessageSource();
		fileReadingMessageSource.setDirectory(directory);
		Message<File> fileMessage = fileReadingMessageSource.receive();
		System.out.println("Received:"+fileMessage);
	}
	public static void main(String[] args) {
		InboundFileAdapter inboundFileAdapterTest = new InboundFileAdapter();
		inboundFileAdapterTest.startFileAdatper();
	}
}
