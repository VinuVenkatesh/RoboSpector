package com.robospector.applicationservice;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

@Component
public class RandomInspectionDetailsGenerator {

	public LocalDate createRandomDate() {
		int currentYear = LocalDate.now().getYear();
		int previousYear = currentYear-1;
		int month = 1 + (int) Math.round(Math.random() * (11));
		int year = previousYear + (int) Math.round(Math.random() * (currentYear-previousYear));
		int day = 1;
		if(month == 2) {
			if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				day = 1 + (int) Math.round(Math.random() * (28));
			}
			else {
				day = 1 + (int) Math.round(Math.random() * (27));
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11) {
			day = 1 + (int) Math.round(Math.random() * (29));
		}
		else {
			day = 1 + (int) Math.round(Math.random() * (30));
		}
		return LocalDate.of(year, month, day);
	}
	
	public LocalTime createRandomTime() {
		int second = 1 + (int) Math.round(Math.random() * (58));
		int minute = 1 + (int) Math.round(Math.random() * (58));
		int hour = (int) Math.round(Math.random() * (23));
		return LocalTime.of(hour, minute, second);
	}
	
	public int createRandomCollectingTime() {
		int collectingTime = 1 + (int) Math.round(Math.random() * (58));
		return collectingTime;
	}
}
