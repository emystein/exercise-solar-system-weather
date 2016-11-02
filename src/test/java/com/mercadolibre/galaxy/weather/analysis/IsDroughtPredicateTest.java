package com.mercadolibre.galaxy.weather.analysis;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.weather.analysis.IsDroughtPredicate;

public class IsDroughtPredicateTest extends SolarSystemTestSupport {

	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		predicate = new IsDroughtPredicate();
	}

	@Test
	public void givenPlanetsAlignedThenWhenCreatingASolarSystemThereShouldBeDrought() throws Exception {
		assertTrue(predicate.matches(orbits));
	}

}