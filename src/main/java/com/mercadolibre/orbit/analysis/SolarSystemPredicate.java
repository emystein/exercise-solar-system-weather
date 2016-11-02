package com.mercadolibre.orbit.analysis;

import java.util.Collection;

import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.SolarSystemEventType;

public abstract class SolarSystemPredicate {

	private SolarSystemEventType eventType;

	public SolarSystemPredicate(SolarSystemEventType eventType) {
		this.eventType = eventType;
	}
	
	public SolarSystemEventType getEventType() {
		return eventType;
	}
	
	public abstract boolean matches(Collection<Orbit> orbits);
}
