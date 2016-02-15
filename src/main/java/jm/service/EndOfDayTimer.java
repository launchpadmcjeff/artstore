package jm.service;

import javax.ejb.Schedule;
import javax.ejb.Stateless;

@Stateless
public class EndOfDayTimer {

	@Schedule(minute = "*", hour = "*")
	public void runEndOfDay() {
		System.out.println("running every night...");
	}
}
