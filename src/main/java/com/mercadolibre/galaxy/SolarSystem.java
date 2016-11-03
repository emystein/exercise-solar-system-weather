package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemAnalysis;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<SolarSystemAnalysis> weatherAnalysis = new ArrayList<>();

	public SolarSystem(Collection<Orbit> orbits, Collection<SolarSystemAnalysis> weatherAnalysisPredicates) {
		this.orbits = orbits;
		this.weatherAnalysis = weatherAnalysisPredicates;
	}

	public DayWeather goToDay(int day) {
		this.reset();

		for (Orbit orbit : this.orbits) {
			orbit.moveDays(day);
		}

		return this.getWeather(day);
	}

	private void reset() {
		this.orbits.forEach(orbit -> orbit.reset());
	}

	private DayWeather getWeather(int day) {
		for (SolarSystemAnalysis analysis : this.weatherAnalysis) {
			if (analysis.matches(this.orbits)) {
				return new DayWeather(day, analysis.getWeather(), analysis.getValue());
			}
		}
		return new DayWeather(day, Weather.NONE);
	}
}
