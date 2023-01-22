package com.spring.weather_application.model.response_body;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDetails_Response {

	private String day;
	private List<WeatherForSpecificTimePeriod_Response> weatherList;
}
