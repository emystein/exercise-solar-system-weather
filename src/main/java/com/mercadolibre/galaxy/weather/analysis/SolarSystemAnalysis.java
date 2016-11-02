package com.mercadolibre.galaxy.weather.analysis;

import java.util.Collection;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public abstract class SolarSystemAnalysis {

	private SolarSystemEventType eventType;

	public SolarSystemAnalysis(SolarSystemEventType eventType) {
		this.eventType = eventType;
	}
	
	public SolarSystemEvent analyze(Collection<Orbit> orbits, int day) {
		if (this.matches(orbits)) {
			return new SolarSystemEvent(day, this.eventType, this.getValue());
		} else {
			return new NullSolarSystemEvent(day);
		}
	}
	
	abstract boolean matches(Collection<Orbit> orbits);
	
	/**
	 * Subclasses can implement this method to store a value associated to the predicate.
	 * @return the value.
	 */
	double getValue() {
		return 0;
	};
}
