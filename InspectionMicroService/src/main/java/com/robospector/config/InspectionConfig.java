package com.robospector.config;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import com.robospector.applicationservice.RandomInspectionDetailsGenerator;
import com.robospector.converters.DateToStringConverter;
import com.robospector.converters.StringToTimeConverter;
import com.robospector.converters.TimeToStringConverter;


@Configuration
public class InspectionConfig{


	@Bean
	public MongoCustomConversions customConversions() {
		List<Converter<?, ?>> converters = new ArrayList<>();
		converters.add(new StringToTimeConverter());
		converters.add(new DateToStringConverter());
		converters.add(new TimeToStringConverter());
		return new MongoCustomConversions(converters);
	}
	
	@Bean
	public RandomInspectionDetailsGenerator detailsGenerator () {
		return new RandomInspectionDetailsGenerator();
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
