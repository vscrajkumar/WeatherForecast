package com.invicara.forcast.weather.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

@Service
public class WeatherForecastServiceImpl implements WeatherForecastService {

	@Autowired
	RestTemplate restTemplate;

	public String getWeatherForecast(String city) {

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		final String weatherApi = "https://api.openweathermap.org/data/2.5/forecast?q=" + city
				+ "&appid=0049058f942c6a19bfa550036cbcb840";
		
		
		return restTemplate.exchange(weatherApi, HttpMethod.GET, entity, String.class).getBody();
		        	 
	}

}
