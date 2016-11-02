package com.mercadolibre.orbit.report;

import java.util.List;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventType;

public class SolarSystemReportResult {

	private Multimap<SolarSystemEventType, SolarSystemEvent> events;
	
	public SolarSystemReportResult(List<SolarSystemEvent> originalEvents) {
		events = MultimapBuilder.enumKeys(SolarSystemEventType.class).arrayListValues().build();
		
		for (SolarSystemEvent event : originalEvents) {
			events.put(event.getType(), event);
		}
	}

	public Multimap<SolarSystemEventType, SolarSystemEvent> getEvents() {
		return events;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (SolarSystemEvent event : events.values()) {
			builder.append(event.toString());
			builder.append("\n");
		}
		return builder.toString();
	}
}
