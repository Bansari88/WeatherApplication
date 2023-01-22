package com.spring.weather_application.model.response_body;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRootClass_Response {

	private City_Response city;
	private List<WeatherDetails_Response> weatherDetails;
}
