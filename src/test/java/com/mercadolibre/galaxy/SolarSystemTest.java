package com.mercadolibre.galaxy;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class SolarSystemTest extends SolarSystemTestSupport {
	private static final double PRECISION = 0.0174d;

	@Test
	public void whenAdvancingOneDayThenFerengiOrbitShouldAdvanceOneDegreeClockwise() throws Exception {
		// exercise
		solarSystem.advanceDays(1);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.toRadians(-1));
		assertThat(ferengiOrbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing90DaysThenFeringiOrbitShouldBeInMinus90Degrees() throws Exception {
		// exercise
		solarSystem.advanceDays(90);
		
		// verify
		Orbit expectedPosition = new Orbit(-(Math.PI / 2));
		assertThat(ferengiOrbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancingOneDayThenVulcanoOrbitShouldAdvanceOneDegreeAnticlockwise() throws Exception {
		// exercise
		solarSystem.advanceDays(1);

		// verify
		Orbit expectedPosition = new Orbit(Math.toRadians(5));
		assertThat(vulcanoOrbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing270DaysThenFeringiOrbitShouldBeIn90Degrees() throws Exception {
		// exercise
		solarSystem.advanceDays(270);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.PI / 2);
		assertThat(ferengiOrbit.getRadians(), is(closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing18DaysThenVulcanoOrbitShouldBeIn90Degrees() throws Exception {
		// exercise
		solarSystem.advanceDays(18);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.PI / 2);
		assertThat(vulcanoOrbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void advanceTenYears() throws Exception {
		solarSystem.advanceDays(3650);
	}

}
