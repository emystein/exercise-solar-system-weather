package com.mercadolibre.orbit.report;

import java.util.List;

import com.mercadolibre.orbit.SolarSystem;
import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventCollector;
import com.mercadolibre.orbit.weather.MaxRainDayCalculator;

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
