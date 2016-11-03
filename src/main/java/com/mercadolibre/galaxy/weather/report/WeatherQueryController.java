package com.mercadolibre.galaxy.weather.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.persistence.DayWeatherRepository;

@RestController
public class WeatherQueryController {

	@Autowired
	private DayWeatherRepository weatherRepository;
	
	@Autowired
	private SolarSystem solarSystem;
	
	@RequestMapping("/clima")
	public DayWeather getWeatherForDay(@RequestParam(name="dia", required=true) int day) {
		DayWeather dayWeather = weatherRepository.findOne(day);

		if (dayWeather == null) {
			dayWeather = solarSystem.getWeatherForDay(day);
			weatherRepository.save(dayWeather);
		}
		
		return dayWeather;
	}
}
