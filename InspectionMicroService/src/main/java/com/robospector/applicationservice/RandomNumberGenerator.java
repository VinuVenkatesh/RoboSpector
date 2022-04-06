package com.robospector.applicationservice;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {

	public RandomNumberGenerator() {
		// TODO Auto-generated constructor stub
	}

	public int generateNumberBetween(int min, int max) {
		return min + (int) Math.round(Math.random() * (max - min));
	}

}