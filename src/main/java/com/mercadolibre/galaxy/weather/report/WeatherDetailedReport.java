package com.mercadolibre.galaxy.weather.report;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.weather.DayWeather;

public class WeatherDetailedReport {

	private SolarSystem solarSystem;

	public WeatherDetailedReport(SolarSystem solarSystem) {
		this.solarSystem = solarSystem;
	}

	public List<DayWeather> execute(int numberOfDays) {
		List<DayWeather> dailyWeather = new ArrayList<>();
		
		for (int day = 1; day <= numberOfDays; day++) {
			dailyWeather.add(solarSystem.getWeatherForDay(day));
		}
		
		return dailyWeather;
	}

}
