package com.mercadolibre.galaxy;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;
import com.mercadolibre.galaxy.weather.report.WeatherQuery;

@Configuration
public class ApplicationConfig {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	@Autowired
	private Collection<SolarSystemPredicate> weatherAnalysisPredicates;

	@Autowired
	private Collection<SolarSystemObserver> observers;

	@Bean
	public SolarSystem solarSystem() throws Exception {
		return new SolarSystem(orbits, weatherAnalysisPredicates, observers);
	}

	@Bean
	public WeatherQuery weatherQuery(SolarSystem solarSystem) {
		return new WeatherQuery(solarSystem);
	}
}
