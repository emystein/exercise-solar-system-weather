package com.kamikaze.solarsystem.weather.report;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kamikaze.solarsystem.SolarSystem;
import com.kamikaze.solarsystem.weather.DayWeather;

public class WeatherSummaryReport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryReport.class);

	private SolarSystem solarSystem;
	private MaxRainDayCalculator maxRainDayCalculator;

	public WeatherSummaryReport(SolarSystem solarSystem, MaxRainDayCalculator maxRainCalculator) {
		this.solarSystem = solarSystem;
		this.maxRainDayCalculator = maxRainCalculator;
	}

	public WeatherSummary execute(int numberOfDays) {
		List<DayWeather> dailyWeather = new ArrayList<>();
		
		for (int day = 1; day <= numberOfDays; day++) {
			dailyWeather.add(solarSystem.getWeatherForDay(day));
		}
		
		dailyWeather.forEach(dayWeather -> logger.trace("Day: {}, Weather: {}", dayWeather.getDay(), dayWeather.getWeather()));
		
		int maxRain = maxRainDayCalculator.calculate(dailyWeather);
		
		return new WeatherSummary(numberOfDays, dailyWeather, maxRain);
	}

}
