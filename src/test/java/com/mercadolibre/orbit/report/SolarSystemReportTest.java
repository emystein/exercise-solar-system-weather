package com.mercadolibre.orbit.report;

import java.util.Collection;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.SolarSystem;
import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventCollector;
import com.mercadolibre.orbit.SolarSystemEventType;
import com.mercadolibre.orbit.analysis.MaxRainDayCalculator;

public class SolarSystemReportTest {
	private static final Logger logger = LoggerFactory.getLogger(SolarSystemReportTest.class);
	
	private static final int TEN_YEARS_IN_DAYS = 3650;
	
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	private SolarSystem solarSystem;

	private SolarSystemEventCollector eventCollector;

	private SolarSystemReport report;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
		eventCollector = new SolarSystemEventCollector();
		solarSystem.registerObserver(eventCollector);
		report = new SolarSystemReport(solarSystem, TEN_YEARS_IN_DAYS, new MaxRainDayCalculator());
	}

	@Test
	public void report() throws Exception {
		SolarSystemReportResult reportResult = report.execute();
		logger.debug(reportResult.toString());

		Assert.assertThat(reportResult.getEvents().size(), Matchers.is(eventCollector.getEvents().size()));
	}
	
	private Collection<SolarSystemEvent> filterEventsBy(Collection<SolarSystemEvent> originalEvents, SolarSystemEventType eventType) {
		// @formatter: off
		Collection<SolarSystemEvent> events = originalEvents.stream()
				.filter(event -> event.getType().equals(eventType))
				.collect(Collectors.toList());
		// @formatter: on
		return events;
	}
}
