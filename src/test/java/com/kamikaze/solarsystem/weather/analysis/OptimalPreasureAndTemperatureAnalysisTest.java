package com.kamikaze.solarsystem.weather.analysis;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.kamikaze.solarsystem.SolarSystemTestSupport;
import com.kamikaze.solarsystem.weather.analysis.OptimalPreasureAndTemperatureAnalysis;
import com.kamikaze.solarsystem.weather.analysis.WeatherAnalysis;

public class OptimalPreasureAndTemperatureAnalysisTest extends SolarSystemTestSupport {
	
	private WeatherAnalysis analysis;

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
