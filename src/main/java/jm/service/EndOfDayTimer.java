package jm.service;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class EndOfDayTimer {

	@Schedule(minute = "10", hour = "*")
	public void runEndOfDay() {
		System.out.println("running every night...");
	}
}
