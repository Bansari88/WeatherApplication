package com.spring.weather_application.model.response_body;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City_Response {

	private String cityName;
	private String country;
	private String sunrise;
	private String sunset;
}
