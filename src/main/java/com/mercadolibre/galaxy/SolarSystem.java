package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<SolarSystemObserver> observers = new ArrayList<>();
	private Collection<SolarSystemPredicate> weatherAnalysisPredicates = new ArrayList<>();
	
	public SolarSystem(Collection<Orbit> orbits, Collection<SolarSystemPredicate> weatherAnalysisPredicates) {
		this.orbits = orbits;
		this.weatherAnalysisPredicates = weatherAnalysisPredicates;
	}

	public void registerObserver(SolarSystemObserver observer) {
		observers.add(observer);
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
		for (SolarSystemPredicate predicate : weatherAnalysisPredicates) {
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

}
