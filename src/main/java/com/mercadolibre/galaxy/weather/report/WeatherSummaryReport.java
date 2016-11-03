package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.galaxy.weather.DayWeather;

public class WeatherSummaryReport {
	private static final Logger logger = LoggerFactory.getLogger(WeatherSummaryReport.class);

	private WeatherDetailedReport detailedReport;
	private MaxRainDayCalculator maxRainDayCalculator;
	
	public WeatherSummaryReport(WeatherDetailedReport detailedReport, MaxRainDayCalculator maxRainCalculator) {
		this.detailedReport = detailedReport;
		this.maxRainDayCalculator = maxRainCalculator;
	}

	public WeatherSummary execute(int numberOfDays) {
		List<DayWeather> dailyWeather = detailedReport.execute(numberOfDays);
		
		dailyWeather.forEach(dayWeather -> logger.trace("Day: {}, Weather: {}", dayWeather.getDay(), dayWeather.getWeather()));
		
		int maxRain = maxRainDayCalculator.calculate(dailyWeather);
		
		return new WeatherSummary(numberOfDays, dailyWeather, maxRain);
	}

}
