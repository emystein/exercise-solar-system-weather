package com.mercadolibre.galaxy.event.observer;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;

public class SolarSystemEventCollector implements SolarSystemObserver {

	private List<SolarSystemEvent> events = new ArrayList<>();

	@Override
	public void notify(SolarSystemEvent event) {
		events.add(event);
	}

	public List<SolarSystemEvent> getEvents() {
		return events;
	}

}