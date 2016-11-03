package com.mercadolibre.galaxy.weather.analysis;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;

public class OptimalPreasureAndTemperatureAnalysisTest extends SolarSystemTestSupport {
	
	private SolarSystemAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new OptimalPreasureAndTemperatureAnalysis();
	}

	@Test
	public void whenCreatingASolarSystemShouldNotExistOptimalConditionsOfPreasureaAndTemperature() throws Exception {
		assertFalse(analysis.matches(orbits));
	}

}
