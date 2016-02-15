package jm.service;

import java.util.concurrent.TimeUnit;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;

import jm.model.WebOrder;

@Stateless
public class EmailNotifierService {

	@Asynchronous
	public void sendSomething(@Observes WebOrder webOrder) {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		System.out.println("***EMAIL*** Order processed for "
				+ webOrder.getCustomer().getName());
	}
}
