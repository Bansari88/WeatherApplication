package com.spring.crud_application.repository;

import org.springframework.stereotype.Repository;

import com.spring.weather_application.model.Location;
import com.spring.weather_application.model.request_body.WeatherRootClass_Input;
import com.spring.weather_application.model.response_body.WeatherRootClass_Response;

@Repository
public interface CityGeneralDetailsRepository {

	public Location fetchCityGeneralDetails(Location currentLocationWeather);

	public WeatherRootClass_Response fetchWeatherDetails(WeatherRootClass_Input inputJson);
}
