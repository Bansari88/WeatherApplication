package com.spring.weather_application.model.request_body;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class City_Input {

	@JsonProperty("name")
	private String cityName;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("sunrise")
	private String sunrise;
	
	@JsonProperty("sunset")
	private String sunset;
	
	@JsonProperty("timezone")
	private Long timezone;
}
