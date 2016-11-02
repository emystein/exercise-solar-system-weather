package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemAnalysis;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<SolarSystemAnalysis> weatherAnalysis = new ArrayList<>();
	private Collection<SolarSystemObserver> observers = new ArrayList<>();
	
	public SolarSystem(Collection<Orbit> orbits, Collection<SolarSystemAnalysis> weatherAnalysisPredicates) {
		this.orbits = orbits;
		this.weatherAnalysis = weatherAnalysisPredicates;
	}

	public void registerObserver(SolarSystemObserver observer) {
		this.observers.add(observer);
	}

	public void advanceDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			for (Orbit orbit : this.orbits) {
				orbit.moveDays(1);
			}
			this.analyzeWeather(day);
		}
	}

	private void analyzeWeather(int day) {
		for (SolarSystemAnalysis analysis : this.weatherAnalysis) {
			SolarSystemEvent event = analysis.analyze(this.orbits, day);
			notifyObservers(event);
		}
	}

	private void notifyObservers(SolarSystemEvent event) {
		this.observers.forEach(observer -> observer.notify(event));
	}

}
