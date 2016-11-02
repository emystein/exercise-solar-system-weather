package com.mercadolibre.galaxy.weather.report;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.observer.LastRegisteredEventObserver;

@RestController
public class WeatherQuery {

	private SolarSystem solarSystem;
	private LastRegisteredEventObserver solarSystemObserver = new LastRegisteredEventObserver();

	@Autowired
	public WeatherQuery(SolarSystem solarSystem) {
		this.solarSystem = solarSystem;
		this.solarSystem.registerObserver(solarSystemObserver);
	}

	@RequestMapping("/clima")
	public SolarSystemEvent getWeather(@RequestParam(name="dia", required=true) int day) {
		this.solarSystem.advanceDays(day);

		// @formatter:off
		return Optional.ofNullable(this.solarSystemObserver.getLastRegisteredEvent())
				.orElse(new NullSolarSystemEvent(day));
		// @formatter:on
	}
}
