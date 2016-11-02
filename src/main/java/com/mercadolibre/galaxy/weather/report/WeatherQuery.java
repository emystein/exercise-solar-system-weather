package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.observer.SolarSystemEventCollector;

public class WeatherQuery {

	private SolarSystem solarSystem;
	private SolarSystemEventCollector eventCollector;

	public WeatherQuery(SolarSystem solarSystem, SolarSystemEventCollector eventCollector) {
		this.solarSystem = solarSystem;
		this.eventCollector = eventCollector;
		this.solarSystem.registerObserver(eventCollector);
	}

	public synchronized SolarSystemEvent getWeather(int day) {
		this.solarSystem.advanceDays(day);

		List<SolarSystemEvent> events = this.eventCollector.getEvents();

		if (!events.isEmpty()) {
			return events.get(events.size() - 1);
		} else {
			return new NullSolarSystemEvent(day);
		}
	}
}
