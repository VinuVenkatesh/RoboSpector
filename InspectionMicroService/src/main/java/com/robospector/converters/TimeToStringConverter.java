package com.robospector.converters;

import java.time.LocalTime;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class TimeToStringConverter implements Converter<LocalTime, String> {

	@Override
	public String convert(LocalTime source) {
		return String.valueOf(source);
	}

}
