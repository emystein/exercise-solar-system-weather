package com.mercadolibre.galaxy.weather.report;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.observer.LastRegisteredEventObserver;

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
