package com.spring.weather_application.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud_application.repository.CityGeneralDetailsRepository;
import com.spring.weather_application.model.City;
import com.spring.weather_application.model.Location;
import com.spring.weather_application.model.WeatherDetails;
import com.spring.weather_application.model.WeatherDuringTimePeriod;
import com.spring.weather_application.model.request_body.City_Input;
import com.spring.weather_application.model.request_body.WeatherDetails_Input;
import com.spring.weather_application.model.request_body.WeatherRootClass_Input;
import com.spring.weather_application.model.response_body.City_Response;
import com.spring.weather_application.model.response_body.WeatherDetails_Response;
import com.spring.weather_application.model.response_body.WeatherForSpecificTimePeriod_Response;
import com.spring.weather_application.model.response_body.WeatherRootClass_Response;

@Service
public class CityGeneralDetails implements CityGeneralDetailsRepository {

	@Autowired
	private DateHelper dateHelper;

	@Override
	public Location fetchCityGeneralDetails(Location location) {

		DateHelper dateHelper = new DateHelper();
		City city = location.getCity();

		String sunriseStr = dateHelper.convertEpochToLocalDateTime(Long.parseLong(city.getSunrise()),
				city.getTimezone());
		String sunsetStr = dateHelper.convertEpochToLocalDateTime(Long.parseLong(city.getSunset()), city.getTimezone());

		city.setSunrise(sunriseStr);
		city.setSunset(sunsetStr);

		List<WeatherDuringTimePeriod> weatherDuringSpecificTimePeriodList = location.getWeatherDuringTimePeriod();

		for (WeatherDuringTimePeriod obj : weatherDuringSpecificTimePeriodList) {

			String date = obj.getDt();
			String dateStr = dateHelper.convertEpochToLocalDateTime(Long.parseLong(date), city.getTimezone());
			obj.setDt(dateStr);

			String[] dateTime = obj.getDt().split(" ");
			obj.setDate(dateTime[0]);
			obj.setTime(dateTime[1].substring(0, dateTime[1].length() - 3));

			WeatherDetails weatherDetails = (obj.getWeatherDetails()).get(0);

			if (weatherDetails.getSky().equals("Clear")) {
				weatherDetails.setSky("sun");
			} else if (weatherDetails.getSky().equals("Clouds")) {
				weatherDetails.setSky("cloud");
			} else if (weatherDetails.getSky().equals("Snow")) {
				weatherDetails.setSky("snowflake");
			} else if (weatherDetails.getSky().equals("Rain")) {
				weatherDetails.setSky("cloud-showers-heavy");
			}

		}
		return location;
	}

	@Override
	public WeatherRootClass_Response fetchWeatherDetails(WeatherRootClass_Input inputJson) {

		WeatherRootClass_Response response = new WeatherRootClass_Response();

		City_Response cityRes = getCityReponse(inputJson.getCity());
		response.setCity(cityRes);

		WeatherDetails_Response weatherDetailsRes = new WeatherDetails_Response();
		List<WeatherForSpecificTimePeriod_Response> weatherForSpecificTimePeriodResList = new ArrayList<>();

		for (WeatherDetails_Input weatherDetails : inputJson.getWeatherDetails()) {

			if (weatherForSpecificTimePeriodResList.size() == 0) {
				String dateStr = weatherDetails.getDateTime();
				String[] date = dateStr.split(" ");
				SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				Date d = null;
				try {
					d = x.parse(date[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				x = new SimpleDateFormat("EEEE");
				String day = x.format(d);
				weatherDetailsRes.setDay(day);
			}

			WeatherForSpecificTimePeriod_Response weatherRes = getWeatherForSpecificTimePeriodRes(weatherDetails);
			weatherForSpecificTimePeriodResList.add(weatherRes);
			if (weatherForSpecificTimePeriodResList.size() == 5) {
				break;
			}
		}

		
		weatherDetailsRes.setWeatherList(weatherForSpecificTimePeriodResList);
		List<WeatherDetails_Response> weatherDetailsResList = new ArrayList<>();
		weatherDetailsResList.add(weatherDetailsRes);
		

		for (WeatherDetails_Input weatherDetails : inputJson.getWeatherDetails()) {
			
			String[] dateTime= weatherDetails.getDateTime().split((" "));
			String time = dateTime[1].substring(0, 2);
			String todayDate = java.time.LocalDate.now().toString();
			
			if(!dateTime[0].equals(todayDate) && time.equals("00")){
				WeatherForSpecificTimePeriod_Response weatherRes = getWeatherForSpecificTimePeriodRes(weatherDetails);
				List<WeatherForSpecificTimePeriod_Response> weatherForSpecificTimePeriodResList1 = new ArrayList<>();
				weatherForSpecificTimePeriodResList1.add(weatherRes);
				
				WeatherDetails_Response weatherDetailsRes1 = new WeatherDetails_Response();
				weatherDetailsRes1.setWeatherList(weatherForSpecificTimePeriodResList1);
				weatherDetailsResList.add(weatherDetailsRes1);
				
				String dateStr = weatherDetails.getDateTime();
				String[] date = dateStr.split(" ");
				SimpleDateFormat x = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
				Date d = null;
				try {
					d = x.parse(date[0]);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				x = new SimpleDateFormat("EEE");
				String day = x.format(d);
				weatherDetailsRes1.setDay(day);
			}
		}
		
		response.setWeatherDetails(weatherDetailsResList);
		
		return response;

	}

	public City_Response getCityReponse(City_Input cityInput) {

		City_Response cityRes = new City_Response();
		cityRes.setCityName(cityInput.getCityName());
		cityRes.setCountry(cityInput.getCountry());

		String sunriseStr = dateHelper.convertEpochToLocalDateTime(Long.parseLong(cityInput.getSunrise()),
				cityInput.getTimezone());
		String sunsetStr = dateHelper.convertEpochToLocalDateTime(Long.parseLong(cityInput.getSunset()),
				cityInput.getTimezone());

		cityRes.setSunrise(sunriseStr);
		cityRes.setSunset(sunsetStr);

		return cityRes;
	}

	public WeatherForSpecificTimePeriod_Response getWeatherForSpecificTimePeriodRes(WeatherDetails_Input weatherInput) {
		WeatherForSpecificTimePeriod_Response weatherRes = new WeatherForSpecificTimePeriod_Response();

		int currentTemp = weatherInput.getTemprature().getCurrentTemp();
		weatherRes.setTemp(currentTemp);

		String sky = weatherInput.getSky().get(0).getSky();
		
		if (sky.equals("Clear")) {
			weatherRes.setWeatherIcon("sun");
		} else if (sky.equals("Clouds")) {
			weatherRes.setWeatherIcon("cloud");
		} else if (sky.equals("Snow")) {
			weatherRes.setWeatherIcon("snowflake");
		} else if (sky.equals("Rain")) {
			weatherRes.setWeatherIcon("cloud-showers-heavy");
		}
		
		

		String dateTimeStr = weatherInput.getDateTime();
		String[] dateTime = dateTimeStr.split(" ");
		weatherRes.setTime(dateTime[1].substring(0, dateTime[1].length() - 3));

		return weatherRes;
	}
}