package com.spring.weather_application.service;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {

	public String convertEpochToLocalDateTime(Long epoch, Long timezone) {

		Date date = new Date(epoch * 1000);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		dateFormat.setTimeZone(TimeZone.getTimeZone(getTimezoneFromOffset(timezone)));
		return dateFormat.format(date);
	}

	public String getTimezoneFromOffset(Long offset) {
		DecimalFormat df = new DecimalFormat("0.00");
		double offsetTime = offset / 3600.00;
		String offsetTimeStr = df.format(offsetTime);
		String decimalPart = (String) offsetTimeStr.subSequence(offsetTimeStr.length() - 2, offsetTimeStr.length());

		String sign = "";
		if (offset >= 0) {
			sign = "+";
		}
		String timezoneStr = "GMT" + sign + (int) offsetTime + ":" + decimalPart;
		return timezoneStr;
	}
}
