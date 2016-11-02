package com.mercadolibre.orbit.query;

import com.mercadolibre.orbit.LastRegisteredEventObserver;
import com.mercadolibre.orbit.SolarSystem;
import com.mercadolibre.orbit.SolarSystemEvent;

public class WeatherQuery {

	private SolarSystem solarSystem;
	private LastRegisteredEventObserver solarSystemObserver = new LastRegisteredEventObserver();

	public WeatherQuery(SolarSystem solarSystem) {
		this.solarSystem = solarSystem;
		this.solarSystem.registerObserver(solarSystemObserver);
	}

	public SolarSystemEvent getWeather(int day) {
		this.solarSystem.advanceDays(day);
		return this.solarSystemObserver.getLastRegisteredEvent();
	}
}
