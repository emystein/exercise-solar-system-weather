package com.mercadolibre.orbit;

import static org.junit.Assert.assertFalse;

import java.awt.geom.Point2D;
import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

public class IsRainingPredicateTest {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);
	
	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

	private SolarSystem solarSystem;
	
	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
		Point2D pointOfTheSun = new Point2D.Double(0, 0);
		predicate = new IsRainingPredicate(pointOfTheSun);
	}

	@Test
	public void whenCreatingASolarSystemShouldNotRain() throws Exception {
		assertFalse(predicate.matches(orbits));
	}

}
