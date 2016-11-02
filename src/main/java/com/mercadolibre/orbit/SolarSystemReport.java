package com.mercadolibre.orbit;

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
