package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class OrbitTest {

	@Test
	public void createOrbitWithClockwiseAngularSpeed() throws Exception {
		int traslationAnglePerDay = -1;
		Orbit ferengiOrbit = new Orbit(500, traslationAnglePerDay);
		
		assertThat(ferengiOrbit.getDistanceToSun(), is(500));
		assertThat(ferengiOrbit.getAngularSpeedPerDay(), is(Math.toRadians(traslationAnglePerDay)));
	}

	@Test
	public void createOrbitWithAnticlockwiseSpeed() throws Exception {
		int traslationAnglePerDay = 1;
		Orbit vulcanoOrbit = new Orbit(1000, traslationAnglePerDay);
		
		assertThat(vulcanoOrbit.getDistanceToSun(), is(1000));
		assertThat(vulcanoOrbit.getAngularSpeedPerDay(), is(Math.toRadians(traslationAnglePerDay)));
	}
	
}
