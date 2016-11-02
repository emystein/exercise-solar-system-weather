package com.mercadolibre.orbit.report;

import java.util.List;

import com.mercadolibre.orbit.SolarSystem;
import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventCollector;
import com.mercadolibre.orbit.analysis.MaxRainDayCalculator;

public class SolarSystemReport {
	
	private SolarSystem solarSystem;
	private SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();
	private int numberOfDays;
	private MaxRainDayCalculator maxRainDayCalculator;
	
	public SolarSystemReport(SolarSystem solarSystem, int numberOfDays, MaxRainDayCalculator maxRainCalculator) {
		this.solarSystem = solarSystem;
		solarSystem.registerObserver(eventCollector);
		this.numberOfDays = numberOfDays;
		this.maxRainDayCalculator = maxRainCalculator;
	}

	public SolarSystemReportResult execute() {
		solarSystem.advanceDays(numberOfDays);
		List<SolarSystemEvent> events = eventCollector.getEvents();
		double maxRain = maxRainDayCalculator.calculate(events);
		SolarSystemReportResult result = new SolarSystemReportResult(events, maxRain);
		return result;
	}

	
}
