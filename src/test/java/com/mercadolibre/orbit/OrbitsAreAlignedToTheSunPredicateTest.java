package com.mercadolibre.orbit;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.orbit.analysis.OrbitsAreAlignedToTheSunPredicate;
import com.mercadolibre.orbit.analysis.SolarSystemPredicate;

public class OrbitsAreAlignedToTheSunPredicateTest {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

	private SolarSystem solarSystem;

	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
		predicate = new OrbitsAreAlignedToTheSunPredicate();
	}

	@Test
	public void whenCreatingASolarSystemPlanetsShouldBeAligned() throws Exception {
		assertTrue(predicate.matches(orbits));
	}

}
