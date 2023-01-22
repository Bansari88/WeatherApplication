package com.spring.weather_application.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class City {

	@JsonProperty("sunrise")
	private String sunrise;
	
	@JsonProperty("sunset")
	private String sunset;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("timezone")
	private Long timezone;
}
