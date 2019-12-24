package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date convertToDate(String date) throws ParseException {
		Date d = sdf.parse(date);
		return d;
	}

	public static Object convertToString(Date date) {
		// TODO Auto-generated method stub
		return sdf.format(date);
	}

}
