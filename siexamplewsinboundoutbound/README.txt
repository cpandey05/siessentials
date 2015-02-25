Refer /META-INF/spring/integration/setting.properties for all the values which can be set

All classes needed to run sample App aer inside package com.cpandey.siexample 
	-select any of those and then "run as Java" program

Following are the details classes which map to chapter wise samples 

Chapter 1-5
	Gateway, Service Activator, Router, Filter, Splitter -EndpointsMailJmsDb.java 
	Aggregator, ChainingHandler -Aggregator.java
	Resequencer, Enricher -Resequencer.java
Chapter 6 
	FTP/FTPS FTPIntegration
	Twitter, SocialIntegration
	JMS, EndpointsMailJmsDb
	Mail EndpointsMailJmsDb
	Database EndpointsMailJmsDb
	HTTP -Separate Project, to be deployed inside tomcat : siexamplehttpinboundoutbound
	WebService -Separate Project, to be deployed inside tomcat : siexamplewsinboundoutbound
Chapter 7 
	Spring Batch BatchJobLauncher.java and SpringIntegrationBatchJobLauncher.java
Chapter 8 
	Testing Files under src/test/java
Chapter 9 and 10 
	JMX and an End to End example :Separate project : feedsexample
