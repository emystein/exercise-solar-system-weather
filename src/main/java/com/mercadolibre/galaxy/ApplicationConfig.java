package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;
import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.event.observer.LastRegisteredEventObserver;
import com.mercadolibre.galaxy.event.observer.SolarSystemEventCollector;
import com.mercadolibre.galaxy.weather.analysis.IsDroughtPredicate;
import com.mercadolibre.galaxy.weather.analysis.IsRainingPredicate;
import com.mercadolibre.galaxy.weather.analysis.OptimalPreasureAndTemperaturePredicate;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;

public class ApplicationConfig {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	@Bean
	public SolarSystem solarSystem() throws Exception {
		// TODO: extract beans
		Collection<SolarSystemPredicate> weatherAnalysisPredicates = new ArrayList<>();
		weatherAnalysisPredicates.add(new IsDroughtPredicate());
		weatherAnalysisPredicates.add(new IsRainingPredicate());
		weatherAnalysisPredicates.add(new OptimalPreasureAndTemperaturePredicate());

		SolarSystem solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates);
		
		// TODO: extract beans of observers
		SolarSystemObserver eventCollector = new SolarSystemEventCollector();
		solarSystem.registerObserver(eventCollector);
		SolarSystemObserver lastRegisteredEventObserver = new LastRegisteredEventObserver();
		solarSystem.registerObserver(lastRegisteredEventObserver);
		
		return solarSystem;
	}

}
