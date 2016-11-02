package com.mercadolibre.orbit.report;

import java.util.List;

import com.mercadolibre.orbit.SolarSystemEvent;

public class WeatherReportResult {

	private int numberOfDays;
	private List<SolarSystemEvent> events;
	private double maxRainDay;
	
	public WeatherReportResult(int numberOfDays, List<SolarSystemEvent> events, double maxRainDay) {
		this.numberOfDays = numberOfDays;
		this.events = events;
		this.maxRainDay = maxRainDay;
	}

	public List<SolarSystemEvent> getEvents() {
		return events;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n");
		builder.append("==============\n");
		builder.append("Weather Report\n");
		builder.append("==============\n");
		
		builder.append("Days: ").append(numberOfDays).append("\n");
		
		for (SolarSystemEvent event : events) {
			builder.append(event.toString()).append("\n");
		}
		
		builder.append("Max rain day: ").append(maxRainDay).append("\n");

		builder.append("=============\n");
		builder.append("End of Report\n");
		builder.append("=============\n");

		return builder.toString();
	}
}
