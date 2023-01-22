package com.spring.weather_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.spring.crud_application.repository.CityGeneralDetailsRepository;
import com.spring.weather_application.model.request_body.WeatherRootClass_Input;
import com.spring.weather_application.model.response_body.WeatherRootClass_Response;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private CityGeneralDetailsRepository cityGeneralDetailsRepository;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/{location}", method = RequestMethod.GET)
	public WeatherRootClass_Response getWeather(@PathVariable(value = "location") String location) {

		String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + location
				+ "&APPID=3156445c226e8e87822c9b008190aaeb&units=metric";

		WeatherRootClass_Input currentLocationWeather = restTemplate.getForObject(url, WeatherRootClass_Input.class);

		WeatherRootClass_Response response = cityGeneralDetailsRepository.fetchWeatherDetails(currentLocationWeather);

		// Location locationResponse =
		// cityGeneralDetailsRepository.fetchCityGeneralDetails(currentLocationWeather);

		return response;
	}

}
