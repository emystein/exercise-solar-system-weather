package com.mercadolibre.orbit;

import java.util.Collection;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportTest {
	private static final Logger logger = LoggerFactory.getLogger(ReportTest.class);
	
	private static final int TEN_YEARS_IN_DAYS = 3650;
	
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	private SolarSystem solarSystem;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
	}

	@Test
	public void informDroughts() throws Exception {
		SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();
		solarSystem.registerObserver(eventCollector);

		solarSystem.advanceDays(TEN_YEARS_IN_DAYS);

		// @formatter: off
		Collection<SolarSystemEvent> events = eventCollector.getEvents().stream()
				.filter(event -> event.getType().equals(SolarSystemEventType.DROUGHT)).collect(Collectors.toList());
		// @formatter: on

		for (SolarSystemEvent event : events) {
			logger.debug(event.toString());
		}
	}

	@Test
	public void informRains() throws Exception {
		SolarSystemEventCollector eventCollector = new SolarSystemEventCollector();
		solarSystem.registerObserver(eventCollector);

		solarSystem.advanceDays(TEN_YEARS_IN_DAYS);

		// @formatter: off
		Collection<SolarSystemEvent> events = eventCollector.getEvents().stream()
				.filter(event -> event.getType().equals(SolarSystemEventType.RAIN)).collect(Collectors.toList());
		// @formatter: on

		for (SolarSystemEvent event : events) {
			logger.debug(event.toString());
		}
	}
}
