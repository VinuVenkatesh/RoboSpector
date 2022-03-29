package com.robospector.converters;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;



@ReadingConverter
@Component
public class StringToTimeConverter implements Converter<String, LocalTime>{

	@Override
	public LocalTime convert(String source) {
		return LocalTime.parse(source);
	}



}
