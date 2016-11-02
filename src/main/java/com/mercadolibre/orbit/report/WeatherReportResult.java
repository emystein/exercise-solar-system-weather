package com.mercadolibre.orbit.report;

import java.util.List;

import com.mercadolibre.orbit.SolarSystemEvent;

public class WeatherReportResult {

	private List<SolarSystemEvent> events;
	private double maxRainDay;
	
	public WeatherReportResult(List<SolarSystemEvent> events, double maxRainDay) {
		this.events = events;
		this.maxRainDay = maxRainDay;
	}

	public List<SolarSystemEvent> getEvents() {
		return events;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (SolarSystemEvent event : events) {
			builder.append(event.toString()).append("\n");
		}
		builder.append("Max rain day: ").append(maxRainDay);
		return builder.toString();
	}
}
