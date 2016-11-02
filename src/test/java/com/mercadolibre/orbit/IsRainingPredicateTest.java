package com.mercadolibre.orbit;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.orbit.weather.IsRainingPredicate;

public class IsRainingPredicateTest extends SolarSystemTestSupport {
	
	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		predicate = new IsRainingPredicate();
	}

	@Test
	public void whenCreatingASolarSystemShouldNotRain() throws Exception {
		assertFalse(predicate.matches(orbits));
	}

}
