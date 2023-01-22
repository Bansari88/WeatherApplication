package com.spring.weather_application.model.request_body;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails_Input {

	@JsonProperty("dt_txt")
	private String dateTime;
	
	@JsonProperty("main")
	private Temprature_Input temprature;
	
	@JsonProperty("weather")
	private List<Sky_Input> sky;
}
