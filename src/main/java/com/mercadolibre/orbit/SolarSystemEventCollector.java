package com.mercadolibre.orbit;

import java.util.ArrayList;
import java.util.List;

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
