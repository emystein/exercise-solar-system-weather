package com.mercadolibre.orbit;

import static org.junit.Assert.assertFalse;

import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.orbit.analysis.OptimalPreasureAndTemperaturePredicate;
import com.mercadolibre.orbit.analysis.SolarSystemPredicate;

public class OptimalPreasureAndTemperaturePredicateTest {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);
	
	private Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

	private SolarSystem solarSystem;
	
	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		solarSystem = new SolarSystem(orbits);
		predicate = new OptimalPreasureAndTemperaturePredicate();
	}

	@Test
	public void whenCreatingASolarSystemShouldNotExistOptimalConditionsOfPreasureaAndTemperature() throws Exception {
		assertFalse(predicate.matches(orbits));
	}

}
