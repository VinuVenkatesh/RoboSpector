package com.robospector.controller;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomNumberGenerator {

	public int getRandomNumberBetween(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min) + min;
	}
	
}
