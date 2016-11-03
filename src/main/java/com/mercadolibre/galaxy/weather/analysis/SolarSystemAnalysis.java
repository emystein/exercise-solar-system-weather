package com.mercadolibre.galaxy.weather.analysis;

import java.util.Collection;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.weather.Weather;

public abstract class SolarSystemAnalysis {

	private Weather weather;

	public SolarSystemAnalysis(Weather weather) {
		this.weather = weather;
	}
	
	public abstract boolean matches(Collection<Orbit> orbits);
	
	public Weather getWeather() {
		return weather;
	}
	
	/**
	 * Subclasses can implement this method to store a value associated to the predicate.
	 * @return the value.
	 */
	public double getValue() {
		return 0;
	};
}
