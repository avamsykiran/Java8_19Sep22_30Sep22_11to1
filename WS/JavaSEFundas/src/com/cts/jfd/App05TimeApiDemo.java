package com.cts.jfd;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class App05TimeApiDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate indDay = LocalDate.of(1947, Month.AUGUST, 15);
		
		LocalDateTime currentTime = LocalDateTime.now();
		ZonedDateTime currentTimeInAustralia = ZonedDateTime.now(ZoneId.of("GMT+10")); 
		
		System.out.println(today);
		System.out.println(indDay);
		System.out.println(currentTime);
		System.out.println(currentTimeInAustralia);
		
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
		System.out.println(today.format(format1));
		System.out.println(indDay.format(format1));
		
		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
		System.out.println(currentTime.format(format2));
		System.out.println(currentTimeInAustralia.format(format2));
		
		System.out.println(Period.between(indDay, today));
		System.out.println(Duration.between(currentTime, LocalDateTime.now()));
		
	}

}
