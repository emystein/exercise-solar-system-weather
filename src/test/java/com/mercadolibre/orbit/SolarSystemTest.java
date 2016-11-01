package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.Collection;

import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.Test;

public class SolarSystemTest {
	private static final double PRECISION = 0.0174d;
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	@Test
	// TODO: review
	public void whenCreatingASolarSystemPositionOfOrbitsShould0AndDistanceToSun() throws Exception {
		Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		SolarSystem solarSystem = new SolarSystem(orbits);

		assertThat(ferengiOrbit.getCoordinates(), is(new Point(500, 0)));
		assertThat(betasoideOrbit.getCoordinates(), is(new Point(2000, 0)));
		assertThat(vulcanoOrbit.getCoordinates(), is(new Point(1000, 0)));
	}

	@Test
	public void whenAdvancingOneDayThenFerengiOrbitShouldAdvanceOneDegreeClockwise() throws Exception {
		Orbit orbit = ferengiOrbit;

		SolarSystem solarSystem = new SolarSystem(Lists.newArrayList(orbit));

		// exercise
		solarSystem.advanceDays(1);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.toRadians(-1));
		assertThat(orbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing90DaysThenFeringiOrbitShouldBeInMinus90Degrees() throws Exception {
		Orbit orbit = ferengiOrbit;

		SolarSystem solarSystem = new SolarSystem(Lists.newArrayList(orbit));

		// exercise
		solarSystem.advanceDays(90);
		
		// verify
		Orbit expectedPosition = new Orbit(-(Math.PI / 2));
		assertThat(orbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancingOneDayThenVulcanoOrbitShouldAdvanceOneDegreeAnticlockwise() throws Exception {
		Orbit orbit = vulcanoOrbit;

		SolarSystem solarSystem = new SolarSystem(Lists.newArrayList(orbit));

		// exercise
		solarSystem.advanceDays(1);

		// verify
		Orbit expectedPosition = new Orbit(Math.toRadians(5));
		assertThat(orbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing270DaysThenFeringiOrbitShouldBeIn90Degrees() throws Exception {
		Orbit orbit = ferengiOrbit;

		SolarSystem solarSystem = new SolarSystem(Lists.newArrayList(orbit));

		// exercise
		solarSystem.advanceDays(270);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.PI / 2);
		assertThat(orbit.getRadians(), is(closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing18DaysThenVulcanoOrbitShouldBeIn90Degrees() throws Exception {
		Orbit orbit = vulcanoOrbit;

		SolarSystem solarSystem = new SolarSystem(Lists.newArrayList(orbit));

		// exercise
		solarSystem.advanceDays(18);
		
		// verify
		Orbit expectedPosition = new Orbit(Math.PI / 2);
		assertThat(orbit.getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void advanceTenYears() throws Exception {
		Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		SolarSystem solarSystem = new SolarSystem(orbits);
		solarSystem.advanceDays(3650);
	}

	
	@Test
	public void whenCreatingASolarSystemPlanetsShouldBeAligned() throws Exception {
		Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		SolarSystem solarSystem = new SolarSystem(orbits);

		assertTrue(solarSystem.orbitsAreAlignedToTheSun());
	}

	@Test
	public void whenCreatingASolarSystemShouldNotRain() throws Exception {
		Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		SolarSystem solarSystem = new SolarSystem(orbits);

		assertFalse(solarSystem.isRaining());
	}

	@Test
	public void whenCreatingASolarSystemShouldNotExistOptimalConditionsOfPreasureaAndTemperature() throws Exception {
		Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		SolarSystem solarSystem = new SolarSystem(orbits);

		assertFalse(solarSystem.optimalConditionsOfPreasureAndTemperature());
	}

	private void assertPoint(SolarSystem solarSystem, Orbit orbit, Point2D expectedPoint) {
		Point2D newPoint = orbit.getCoordinates();
		assertThat(newPoint.getX(), is(Matchers.closeTo(expectedPoint.getX(), PRECISION)));
		assertThat(newPoint.getY(), is(Matchers.closeTo(expectedPoint.getY(), PRECISION)));
	}

	private Point2D getNewPointAfterMovingOrbit(Orbit orbit, Point2D oldPoint) {
		double deltaAngle = orbit.getAngularSpeedPerDay();
		double newX = orbit.getDistanceToSun() * Math.cos(deltaAngle);
		double newY = oldPoint.getY() + (orbit.getDistanceToSun() * Math.sin(deltaAngle));
		Point2D expectedPoint = new Point2D.Double(newX, newY);
		return expectedPoint;
	}
}
