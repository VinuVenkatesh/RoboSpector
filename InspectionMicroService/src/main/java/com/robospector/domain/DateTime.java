package com.robospector.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	private LocalDate date;
	private LocalTime time;

	public DateTime() {
		super();
		
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate() {
		this.date = LocalDate.now();
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime() {
		this.time = LocalTime.parse(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))); 
	}
	
	public void setRandomDate(LocalDate date) {
		this.date = date;
	}
	
	public void setRandomTime(LocalTime time) {
		this.time = time;
	}
}
