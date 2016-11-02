package com.mercadolibre.galaxy.weather.analysis;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.event.NullSolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEvent;

public class OptimalPreasureAndTemperatureAnalysisTest extends SolarSystemTestSupport {
	
	private SolarSystemAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new OptimalPreasureAndTemperatureAnalysis();
	}

	@Test
	public void whenCreatingASolarSystemShouldNotExistOptimalConditionsOfPreasureaAndTemperature() throws Exception {
		SolarSystemEvent event = analysis.analyze(orbits, 1);
		
		assertThat(event, instanceOf(NullSolarSystemEvent.class));
	}

}
