package com.mercadolibre.galaxy.weather.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.weather.DayWeather;

@RestController
@Scope("request")
public class WeatherQueryController {

	@Autowired
	private SolarSystem solarSystem;
	
	@RequestMapping("/clima")
	public DayWeather getWeather(@RequestParam(name="dia", required=true) int day) {
		return solarSystem.goToDay(day);
	}
}
