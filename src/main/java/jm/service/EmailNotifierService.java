package jm.service;

import java.util.concurrent.TimeUnit;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import jm.model.Order;

@Stateless
public class EmailNotifierService {

	private static final Logger LOGGER = Logger.getLogger(EmailNotifierService.class);
	
	@Asynchronous
	public void sendSomething(@Observes Order webOrder) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		LOGGER.info("***EMAIL*** Order processed for ");
	}
}
