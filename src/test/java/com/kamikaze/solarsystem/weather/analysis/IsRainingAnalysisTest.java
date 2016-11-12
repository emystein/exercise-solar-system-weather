package com.kamikaze.solarsystem.weather.analysis;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import com.kamikaze.solarsystem.SolarSystemTestSupport;
import com.kamikaze.solarsystem.weather.analysis.IsRainingAnalysis;
import com.kamikaze.solarsystem.weather.analysis.WeatherAnalysis;

public class IsRainingAnalysisTest extends SolarSystemTestSupport {
	
	private WeatherAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new IsRainingAnalysis();
	}

	@Test
	public void whenCreatingASolarSystemShouldNotRain() throws Exception {
		assertFalse(analysis.matches(orbits));
	}

}
