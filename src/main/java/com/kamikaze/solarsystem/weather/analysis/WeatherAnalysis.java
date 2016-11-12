package com.kamikaze.solarsystem.weather.analysis;

import java.util.Collection;

import com.kamikaze.solarsystem.Orbit;
import com.kamikaze.solarsystem.weather.Weather;

public abstract class WeatherAnalysis {

	private Weather weather;

	public WeatherAnalysis(Weather weather) {
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
