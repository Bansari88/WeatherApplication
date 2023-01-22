package com.spring.weather_application.model.response_body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherForSpecificTimePeriod_Response {

	private int temp;
	private String weatherIcon;
	private String time;
}
