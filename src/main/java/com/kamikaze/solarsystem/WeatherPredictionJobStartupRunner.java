package com.kamikaze.solarsystem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kamikaze.solarsystem.weather.persistence.WeatherPredictionJob;

/**
 * Indicates Spring to run {@link WeatherPredictionJob} on application startup.
 * @author emenendez
 *
 */
@Component
public class WeatherPredictionJobStartupRunner {

	@Autowired
	private WeatherPredictionJob job;
	
	@Value("${solarsystem.weather.startup.predict.years:10}")
	private int years;
	
	@PostConstruct
	public void run() {
		job.predictYears(years);
	}
	
	public int getNumberOfYearsToPredict() {
		return years;
	}
}
