package com.mercadolibre.galaxy.weather.analysis;

import static com.mercadolibre.galaxy.event.SolarSystemEventType.OPTIMAL_PREASSURE_AND_TEMPERATURE;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.weather.analysis.OptimalPreasureAndTemperaturePredicate;

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
