package com.mercadolibre.orbit;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Point2D pointOfTheSun = new Point2D.Double(0, 0);
	private Collection<SolarSystemObserver> observers = new ArrayList<>();
	private Collection<SolarSystemPredicate> predicates = new ArrayList<>();

	public SolarSystem(Collection<Orbit> orbits) {
		this.orbits = orbits;
		predicates.add(new OrbitsAreAlignedToTheSunPredicate());
		predicates.add(new IsRainingPredicate(pointOfTheSun));
		predicates.add(new OptimalPreasureAndTemperaturePredicate());
	}

	public Collection<Orbit> getOrbits() {
		return orbits;
	}

	// TODO: move to SolarTime class?
	public void advanceDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			for (Orbit orbit : orbits) {
				orbit.moveDays(1);
			}
			this.generateEvents(day);
		}
	}

	// TODO: extract event listener logic
	private void generateEvents(int day) {
		List<SolarSystemEvent> events = new ArrayList<>();

		for (SolarSystemPredicate predicate : predicates) {
			if (predicate.matches(orbits)) {
				events.add(new SolarSystemEvent(day, predicate.getEventType()));
			}
		}
		
		for (SolarSystemEvent event : events) {
			notifyObservers(event);
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
