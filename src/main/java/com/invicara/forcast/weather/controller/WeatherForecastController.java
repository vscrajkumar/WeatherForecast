package com.invicara.forcast.weather.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.invicara.forcast.weather.service.WeatherForecastService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/forecast")
public class WeatherForecastController {

	@Autowired
	WeatherForecastService weatherForecastService;
	
	@GetMapping(path="/{city}")
	public String getWeatherForecast(@PathVariable String city){
		
		return weatherForecastService.getWeatherForecast(city);
	}
	
	@GetMapping()
	public String getWeatherForecastQueryString(@RequestParam(name = "city", required = false, defaultValue = "chennai") String city){
		
		return weatherForecastService.getWeatherForecast(city);

	}
}
