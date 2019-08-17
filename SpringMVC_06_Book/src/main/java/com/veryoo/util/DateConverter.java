package com.veryoo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {
	
	private Log log = LogFactory.getLog(DateConverter.class);

	@Override
	public Date convert(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(source);
		}catch (Exception e) {
			log.warn("日期转换失败：\"" + source + "\"");
		}
		return null;
	}

}
