package com.cpandey.siexample.jmx;

import javax.management.Notification;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

@Component
@ManagedResource
public class TestMBean implements NotificationPublisherAware{
	private NotificationPublisher notificationPublisher;
	private String managedData;
	
	@ManagedAttribute
	public String getManagedData() {
		return managedData;
	}
	@ManagedAttribute
	public void setManagedData(String managedData) {
		this.managedData = managedData;
	}
	@ManagedOperation
	public Integer testAdd(Integer num1, Integer num2) {
		notificationPublisher.sendNotification(new Notification("testAdd", this, 0));
	return num1 + num2;
	}
	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;
	}
}
