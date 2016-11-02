package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<SolarSystemPredicate> weatherAnalysisPredicates = new ArrayList<>();
	private Collection<SolarSystemObserver> observers = new ArrayList<>();
	
	public SolarSystem(Collection<Orbit> orbits, Collection<SolarSystemPredicate> weatherAnalysisPredicates) {
		this.orbits = orbits;
		this.weatherAnalysisPredicates = weatherAnalysisPredicates;
	}

	public SolarSystem(Collection<Orbit> orbits, Collection<SolarSystemPredicate> weatherAnalysisPredicates,
			Collection<SolarSystemObserver> observers) {
		this(orbits, weatherAnalysisPredicates);

		for (SolarSystemObserver solarSystemObserver : observers) {
			this.registerObserver(solarSystemObserver);
		}
	}

	public void registerObserver(SolarSystemObserver observer) {
		if (!this.observers.contains(observer)) {
			this.observers.add(observer);
		}
	}

	public void advanceDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			for (Orbit orbit : this.orbits) {
				orbit.moveDays(1);
			}
			this.generateEvents(day);
		}
	}

	private void generateEvents(int day) {
		for (SolarSystemPredicate predicate : this.weatherAnalysisPredicates) {
			if (predicate.matches(this.orbits)) {
				SolarSystemEvent event = new SolarSystemEvent(day, predicate.getEventType(), predicate.getValue());
				notifyObservers(event);
			}
		}
	}

	private void notifyObservers(SolarSystemEvent event) {
		for (SolarSystemObserver observer : this.observers) {
			observer.notify(event);
		}
	}

}
