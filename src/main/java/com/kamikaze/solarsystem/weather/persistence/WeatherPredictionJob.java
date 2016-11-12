package com.kamikaze.solarsystem.weather.persistence;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kamikaze.solarsystem.SolarSystem;
import com.kamikaze.solarsystem.weather.DayWeather;

@Component
public class WeatherPredictionJob {
	private static final Logger logger = LoggerFactory.getLogger(WeatherPredictionJob.class);

	@Autowired
	private SolarSystem solarSystem;

	@Autowired
	private DayWeatherRepository weatherRepository;
	
	@Transactional
	public void predictYears(int years) {
		logger.info("Starting weather prediction job for {} years", years);
		
		int numberOfDays = years * 365;
		
		for (int day = 1; day <= numberOfDays; day++) {
			DayWeather weatherForDay = solarSystem.getWeatherForDay(day);
			weatherRepository.save(weatherForDay);
		}
		
		logger.info("Finished weather prediction job");
	}
	
	
}
