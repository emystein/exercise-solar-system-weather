package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventCollector;

@Component
@Scope("request")
public class WeatherQuery {

	private SolarSystem solarSystem;
	private SolarSystemEventCollector eventCollector;

	@Autowired
	public WeatherQuery(SolarSystem solarSystem, SolarSystemEventCollector eventCollector) {
		this.solarSystem = solarSystem;
		this.eventCollector = eventCollector;
	}

	public SolarSystemEvent getWeather(int day) {
		this.solarSystem.goToDay(day);

		List<SolarSystemEvent> events = this.eventCollector.getEvents();

		if (!events.isEmpty()) {
			return events.get(0);
		} else {
			return new NullSolarSystemEvent(day);
		}
	}
}
