package com.spring.weather_application.model.response_body;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather_Response {

	private List<WeatherForSpecificTimePeriod_Response> weatherForSpecificTimePeriod;
}
