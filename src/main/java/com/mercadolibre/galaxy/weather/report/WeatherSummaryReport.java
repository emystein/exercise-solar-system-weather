package com.mercadolibre.galaxy.weather.report;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.weather.DayWeather;

public class WeatherSummaryReport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryReport.class);

	private SolarSystem solarSystem;
	private MaxRainDayCalculator maxRainDayCalculator;
	
	public WeatherSummaryReport(SolarSystem solarSystem, MaxRainDayCalculator maxRainCalculator) {
		this.solarSystem = solarSystem;
		this.maxRainDayCalculator = maxRainCalculator;
	}

	public WeatherSummary execute(int numberOfDays) {
		List<DayWeather> dailyWeather = advanceDays(numberOfDays);
		
		dailyWeather.forEach(dayWeather -> logger.trace("Day: {}, Weather: {}", dayWeather.getDay(), dayWeather.getWeather()));
		
		int maxRain = maxRainDayCalculator.calculate(dailyWeather);
		
		return new WeatherSummary(numberOfDays, dailyWeather, maxRain);
	}

	public List<DayWeather> advanceDays(int numberOfDays) {
		List<DayWeather> dailyWeather = new ArrayList<>();
		
		for (int day = 1; day <= numberOfDays; day++) {
			dailyWeather.add(solarSystem.getWeatherForDay(day));
		}
		
		return dailyWeather;
	}
}
