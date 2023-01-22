package com.spring.weather_application.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {

	@JsonProperty("city")
	private City city;
	
	@JsonProperty("list")
	private List<WeatherDuringTimePeriod> weatherDuringTimePeriod;

}
