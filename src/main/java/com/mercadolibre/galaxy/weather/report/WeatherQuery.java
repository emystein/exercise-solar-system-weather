package com.mercadolibre.galaxy.weather.report;

import java.util.Optional;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
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
		// @formatter:off
		return Optional.ofNullable(this.solarSystemObserver.getLastRegisteredEvent())
				.orElse(new NullSolarSystemEvent(day));
		// @formatter:on
	}
}
