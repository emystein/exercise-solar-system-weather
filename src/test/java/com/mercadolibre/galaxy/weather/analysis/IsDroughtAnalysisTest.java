package com.mercadolibre.galaxy.weather.analysis;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public class IsDroughtAnalysisTest extends SolarSystemTestSupport {

	private SolarSystemAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new IsDroughtAnalysis();
	}

	@Test
	public void givenPlanetsAlignedThenWhenCreatingASolarSystemThereShouldBeDrought() throws Exception {
		SolarSystemEvent event = analysis.analyze(orbits, 1);
		
		assertThat(event.getDay(), is(1));
		assertThat(event.getType(), is(SolarSystemEventType.DROUGHT));
	}

}
