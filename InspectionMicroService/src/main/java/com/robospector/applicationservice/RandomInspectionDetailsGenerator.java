package com.robospector.applicationservice;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomInspectionDetailsGenerator {

	@Autowired
	private RandomNumberGenerator randomNumberGenerator;

	public RandomInspectionDetailsGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}
	
	public LocalDate createRandomDate() {
		int currentYear = LocalDate.now().getYear();
		int previousYear = currentYear - 1;
		int month = randomNumberGenerator.generateNumberBetween(1, 12);
		int year = randomNumberGenerator.generateNumberBetween(previousYear, currentYear);
		int day = randomNumberGenerator.generateNumberBetween(1, 28);
		return LocalDate.of(year, month, day);
	}

	public LocalTime createRandomTime() {
		int second = randomNumberGenerator.generateNumberBetween(1, 59);
		int minute = randomNumberGenerator.generateNumberBetween(1, 59);
		int hour = randomNumberGenerator.generateNumberBetween(0, 23);
		return LocalTime.of(hour, minute, second);
	}

	public int createRandomCollectingTime() {
		int collectingTime = randomNumberGenerator.generateNumberBetween(1, 59);
		return collectingTime;
	}
}
