package jm.service;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

import org.jboss.logging.Logger;

@Stateless
public class EndOfDayTimer {
	private static final Logger LOGGER = Logger.getLogger(EndOfDayTimer.class);
	
	@Schedule(minute = "10", hour = "*")
	public void runEndOfDay() {
		LOGGER.info("running every night...");
	}
}
