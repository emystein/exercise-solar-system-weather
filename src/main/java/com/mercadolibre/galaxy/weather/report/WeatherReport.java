package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.observer.SolarSystemEventCollector;
import com.mercadolibre.galaxy.weather.analysis.MaxRainDayCalculator;

public class WeatherReport {
	
	private SolarSystem solarSystem;
	private SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();
	private MaxRainDayCalculator maxRainDayCalculator;
	
	public WeatherReport(SolarSystem solarSystem, MaxRainDayCalculator maxRainCalculator) {
		this.solarSystem = solarSystem;
		solarSystem.registerObserver(eventCollector);
		this.maxRainDayCalculator = maxRainCalculator;
	}

	public WeatherReportResult execute(int numberOfDays) {
		solarSystem.advanceDays(numberOfDays);
		
		List<SolarSystemEvent> events = eventCollector.getEvents();
		
		double maxRain = maxRainDayCalculator.calculate(events);
		
		return new WeatherReportResult(numberOfDays, events, maxRain);
	}

	
}
