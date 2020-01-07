package jm.service;

import java.util.concurrent.TimeUnit;

import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import jm.model.Order;

public class SmsNotifierService {
	private static final Logger LOGGER = Logger.getLogger(SmsNotifierService.class);
	
	public void sendSomething(@Observes Order webOrder) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		LOGGER.info("***SMS*** Order processed for ");
	}
}
