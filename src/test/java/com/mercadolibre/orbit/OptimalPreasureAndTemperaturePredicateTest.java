package com.mercadolibre.orbit;

import static com.mercadolibre.orbit.SolarSystemEventType.OPTIMAL_PREASSURE_AND_TEMPERATURE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.orbit.weather.OptimalPreasureAndTemperaturePredicate;

public class OptimalPreasureAndTemperaturePredicateTest extends SolarSystemTestSupport {
	
	private SolarSystemPredicate predicate;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		predicate = new OptimalPreasureAndTemperaturePredicate();
	}

	@Test
	public void predicateType() throws Exception {
		assertThat(predicate.getEventType(), is(OPTIMAL_PREASSURE_AND_TEMPERATURE));
	}
	
	@Test
	public void whenCreatingASolarSystemShouldNotExistOptimalConditionsOfPreasureaAndTemperature() throws Exception {
		assertFalse(predicate.matches(orbits));
	}

}
