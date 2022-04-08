package com.robospector.converters;

import java.time.LocalDate;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
@Component
public class DateToStringConverter implements Converter<LocalDate, String>{

	@Override
	public String convert(LocalDate source) {
		// TODO Auto-generated method stub
		return String.valueOf(source);
	}



}
