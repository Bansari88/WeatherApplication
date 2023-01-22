package com.spring.weather_application.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDuringTimePeriod {

	@JsonProperty("dt")
	private String dt;
	
	private String date;
	private String time;

	@JsonProperty("main")
	private TemperatureDetails temperatureDetails;

	@JsonProperty("weather")
	private List<WeatherDetails> weatherDetails;
}
