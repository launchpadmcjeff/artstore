package jm.service;

import java.util.concurrent.TimeUnit;

import javax.enterprise.event.Observes;

import jm.model.WebOrder;

public class SmsNotifierService {

	public void sendSomething(@Observes WebOrder webOrder) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("***SMS*** Order processed for "
				+ webOrder.getCustomer().getName());
	}
}
