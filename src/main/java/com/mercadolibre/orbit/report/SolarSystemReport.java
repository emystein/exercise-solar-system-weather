package com.mercadolibre.orbit.report;

import com.mercadolibre.orbit.SolarSystem;
import com.mercadolibre.orbit.SolarSystemEventCollector;

public class SolarSystemReport {
	
	private SolarSystem solarSystem;
	private SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();
	private int numberOfDays;
	
	public SolarSystemReport(SolarSystem solarSystem, int numberOfDays) {
		this.solarSystem = solarSystem;
		solarSystem.registerObserver(eventCollector);
		this.numberOfDays = numberOfDays;
	}

	public SolarSystemReportResult execute() {
		solarSystem.advanceDays(numberOfDays);
		SolarSystemReportResult result = new SolarSystemReportResult(eventCollector.getEvents());
		return result;
	}

}
