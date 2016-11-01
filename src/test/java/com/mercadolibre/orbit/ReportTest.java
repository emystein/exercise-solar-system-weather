package com.mercadolibre.orbit;

import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;

public class ReportTest {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	@Test
	public void informDroughts() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		SolrSystemEventCollector eventCollector = new SolrSystemEventCollector();
		solarSystem.registerObserver(eventCollector);
		
		solarSystem.advanceDays(3650);
		
		// @formatter: off
		Collection<SolrSystemEvent> droughts = eventCollector.getEvents().stream()
				.filter(event -> event.getType().equals(SolrSystemEventType.DROUGHT))
				.collect(Collectors.toList());
		// @formatter: on
		
		for (SolrSystemEvent drought: droughts) {
			System.out.println(drought);
		}
	}
}
