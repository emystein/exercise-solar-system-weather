package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.awt.geom.Point2D;

import org.junit.Test;

public class OrbitTest {
	
	@Test
	public void createOrbitWithAnticlockwiseSpeed() throws Exception {
		int traslationAnglePerDay = 1;
		Orbit vulcanoOrbit = new Orbit(1000, traslationAnglePerDay);
		
		assertThat(vulcanoOrbit.getDistanceToSun(), is(1000));
		assertThat(vulcanoOrbit.getAngularSpeedPerDay(), is(Math.toRadians(traslationAnglePerDay)));
		assertThat(vulcanoOrbit.getCoordinates(), is(new Point2D.Double(1000, 0)));
	}

	@Test
	public void createOrbitWithClockwiseAngularSpeed() throws Exception {
		int traslationAnglePerDay = -1;
		Orbit ferengiOrbit = new Orbit(500, traslationAnglePerDay);
		
		assertThat(ferengiOrbit.getDistanceToSun(), is(500));
		assertThat(ferengiOrbit.getAngularSpeedPerDay(), is(Math.toRadians(traslationAnglePerDay)));
	}

	@Test
	public void moveOrbitWithAnticlockwiseSpeed() throws Exception {
		int traslationAnglePerDay = 1;
		Orbit vulcanoOrbit = new Orbit(1000, traslationAnglePerDay);

		vulcanoOrbit.moveDays(90);
		
		assertThat(vulcanoOrbit.getCoordinates(), is(new Point2D.Double(0, 1000)));
	}

	@Test
	public void moveOrbitWithClockwiseSpeed() throws Exception {
		int traslationAnglePerDay = -1;
		Orbit ferengiOrbit = new Orbit(500, traslationAnglePerDay);

		ferengiOrbit.moveDays(90);
		
		assertThat(ferengiOrbit.getCoordinates(), is(new Point2D.Double(0, -500)));
	}
}
