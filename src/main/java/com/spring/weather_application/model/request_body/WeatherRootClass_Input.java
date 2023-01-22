package com.spring.weather_application.model.request_body;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherRootClass_Input {
	
	@JsonProperty("city")
	private City_Input city;
	
	@JsonProperty("list")
	private List<WeatherDetails_Input> weatherDetails;
}
