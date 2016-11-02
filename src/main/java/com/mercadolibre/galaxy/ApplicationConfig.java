package com.mercadolibre.galaxy;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.mercadolibre.galaxy.event.SolarSystemEventCollector;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemAnalysis;

@Configuration
public class ApplicationConfig {
	@Bean
	@Scope("request")
	public Collection<Orbit> orbits() {
		Orbit ferengiOrbit = new Orbit(500, -1);
		Orbit betasoideOrbit = new Orbit(2000, -3);
		Orbit vulcanoOrbit = new Orbit(1000, 5);
		
		return Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	}

	@Bean
	@Scope("request")
	public SolarSystem solarSystem(Collection<Orbit> orbits, Collection<SolarSystemAnalysis> weatherAnalysisPredicates, SolarSystemEventCollector solarSystemEventCollector) {
		SolarSystem solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates);
		solarSystem.registerObserver(solarSystemEventCollector);
		return solarSystem;
	}
	
}
