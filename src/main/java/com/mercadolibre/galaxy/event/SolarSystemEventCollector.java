package com.mercadolibre.galaxy.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
public class SolarSystemEventCollector implements SolarSystemObserver {

	private List<SolarSystemEvent> events = new ArrayList<>();

	@Override
	public void notify(SolarSystemEvent event) {
		if (!(event instanceof NullSolarSystemEvent)) {
			events.add(event);
		}
	}

	public List<SolarSystemEvent> getEvents() {
		return events;
	}

}
