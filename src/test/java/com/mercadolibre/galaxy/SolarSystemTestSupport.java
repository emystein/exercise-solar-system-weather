package com.mercadolibre.galaxy;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.SolarSystem;
import com.mercadolibre.galaxy.event.observer.SolarSystemEventCollector;

public class SolarSystemTestSupport {
	protected Orbit ferengiOrbit = new Orbit(500, -1);
	protected Orbit betasoideOrbit = new Orbit(2000, -3);
	protected Orbit vulcanoOrbit = new Orbit(1000, 5);

	protected Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	protected SolarSystem solarSystem;

	protected SolarSystemEventCollector eventCollector;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
		eventCollector = new SolarSystemEventCollector();
		solarSystem.registerObserver(eventCollector);
	}
}
