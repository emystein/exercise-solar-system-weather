package com.mercadolibre.orbit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.orbit.weather.OrbitsAreAlignedToTheSunPredicate;

public class OrbitsAreAlignedToTheSunPredicateTest extends SolarSystemTestSupport {

	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		predicate = new OrbitsAreAlignedToTheSunPredicate();
	}

	@Test
	public void whenCreatingASolarSystemPlanetsShouldBeAligned() throws Exception {
		assertTrue(predicate.matches(orbits));
	}

}
