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
	
	/**
	 * Subclasses can implement this method to store a value associated to the predicate.
	 * @return the value.
	 */
	public double getValue() {
		return 0;
	};
}
