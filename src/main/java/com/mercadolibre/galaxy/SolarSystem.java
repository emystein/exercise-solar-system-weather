package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import com.mercadolibre.galaxy.weather.DayWeather;
import com.mercadolibre.galaxy.weather.Weather;
import com.mercadolibre.galaxy.weather.analysis.WeatherAnalysis;

public class SolarSystem {
	private Collection<Orbit> orbits;
	private Collection<WeatherAnalysis> weatherAnalysis = new ArrayList<>();

	public SolarSystem(Collection<Orbit> orbits, Collection<WeatherAnalysis> weatherAnalysisPredicates) {
		this.orbits = orbits;
		this.weatherAnalysis = weatherAnalysisPredicates;
	}

	public void moveOrbitsTo(int day) {
		reset();
		orbits.forEach(orbit -> orbit.moveDays(day));
	}
	
	public DayWeather getWeatherForDay(int day) {
		moveOrbitsTo(day);
		return analyzeWeatherOf(day);
	}

	private DayWeather analyzeWeatherOf(int day) {
		for (WeatherAnalysis analysis : weatherAnalysis) {
			if (analysis.matches(orbits)) {
				return new DayWeather(day, analysis.getWeather(), analysis.getValue());
			}
		}
		return new DayWeather(day, Weather.NONE);
	}

	private void reset() {
		this.orbits.forEach(orbit -> orbit.reset());
	}
}
