package com.mercadolibre.galaxy.weather.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.weather.DayWeather;

@RestController
public class WeatherQueryController {

	@Autowired
	private SolarSystem solarSystem;
	
	@RequestMapping("/clima")
	public DayWeather getWeatherForDay(@RequestParam(name="dia", required=true) int day) {
		return solarSystem.getWeatherForDay(day);
	}
}
