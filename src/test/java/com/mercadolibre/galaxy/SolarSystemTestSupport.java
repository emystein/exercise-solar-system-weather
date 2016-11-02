package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;

import com.mercadolibre.galaxy.event.SolarSystemObserver;
import com.mercadolibre.galaxy.event.observer.SolarSystemEventCollector;
import com.mercadolibre.galaxy.weather.analysis.IsDroughtPredicate;
import com.mercadolibre.galaxy.weather.analysis.IsRainingPredicate;
import com.mercadolibre.galaxy.weather.analysis.OptimalPreasureAndTemperaturePredicate;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;

public class SolarSystemTestSupport {
	protected Orbit ferengiOrbit = new Orbit(500, -1);
	protected Orbit betasoideOrbit = new Orbit(2000, -3);
	protected Orbit vulcanoOrbit = new Orbit(1000, 5);

	protected Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	protected SolarSystem solarSystem;

	protected SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();

	@Before
	public void setUp() throws Exception {
		Collection<SolarSystemPredicate> weatherAnalysisPredicates = new ArrayList<>();
		weatherAnalysisPredicates.add(new IsDroughtPredicate());
		weatherAnalysisPredicates.add(new IsRainingPredicate());
		weatherAnalysisPredicates.add(new OptimalPreasureAndTemperaturePredicate());

		Collection<SolarSystemObserver> observers = Lists.newArrayList(eventCollector);
		
		solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates, observers);
	}
}
