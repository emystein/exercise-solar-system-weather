package com.mercadolibre.orbit.report;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventType;

public class WeatherReportResult {

	private Multimap<SolarSystemEventType, SolarSystemEvent> events;
	private double maxRainDay;
	
	public WeatherReportResult(List<SolarSystemEvent> originalEvents, double maxRainDay) {
		events = MultimapBuilder.enumKeys(SolarSystemEventType.class).arrayListValues().build();
		
		for (SolarSystemEvent event : originalEvents) {
			events.put(event.getType(), event);
		}
		
		this.maxRainDay = maxRainDay;
	}

	public Multimap<SolarSystemEventType, SolarSystemEvent> getEvents() {
		return events;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (SolarSystemEvent event : events.values()) {
			builder.append(event.toString()).append("\n");
		}
		builder.append("Max rain day: ").append(maxRainDay);
		return builder.toString();
	}
}
