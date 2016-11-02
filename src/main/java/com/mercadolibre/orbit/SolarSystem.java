package com.mercadolibre.orbit;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.orbit.weather.IsRainingPredicate;
import com.mercadolibre.orbit.weather.OptimalPreasureAndTemperaturePredicate;
import com.mercadolibre.orbit.weather.OrbitsAreAlignedToTheSunPredicate;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<SolarSystemObserver> observers = new ArrayList<>();
	private Collection<SolarSystemPredicate> predicates = new ArrayList<>();
	
	public SolarSystem(Collection<Orbit> orbits) {
		this.orbits = orbits;
		predicates.add(new OrbitsAreAlignedToTheSunPredicate());
		predicates.add(new IsRainingPredicate());
		predicates.add(new OptimalPreasureAndTemperaturePredicate());
	}

	public Collection<Orbit> getOrbits() {
		return orbits;
	}

	public void advanceDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			for (Orbit orbit : orbits) {
				orbit.moveDays(1);
			}
			this.generateEvents(day);
		}
	}

	private void generateEvents(int day) {
		for (SolarSystemPredicate predicate : predicates) {
			if (predicate.matches(orbits)) {
				SolarSystemEvent event = new SolarSystemEvent(day, predicate.getEventType(), predicate.getValue());
				notifyObservers(event);
			}
		}
	}

	private void notifyObservers(SolarSystemEvent event) {
		for (SolarSystemObserver observer : observers) {
			observer.notify(event);
		}
	}

	public void registerObserver(SolarSystemObserver observer) {
		observers.add(observer);
	}
}
