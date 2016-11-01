package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.geom.Point2D;

import org.hamcrest.Matchers;
import org.junit.Test;

public class SolarSystemTest {
	private static final double PRECISION = 0.0174d;
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 5);

	@Test
	public void whenCreatingASolarSystemPositionOfOrbitsShould0AndDistanceToSun() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		
		assertThat(solarSystem.positionOf(ferengiOrbit).getPoint(), is(new Point(500, 0))); 
		assertThat(solarSystem.positionOf(betasoideOrbit).getPoint(), is(new Point(2000, 0))); 
		assertThat(solarSystem.positionOf(vulcanoOrbit).getPoint(), is(new Point(1000, 0))); 
	}
	
	@Test
	public void whenAdvancingOneDayThenFerengiOrbitShouldAdvanceOneDegreeClockwise() throws Exception {
		Orbit orbit = ferengiOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		
		// exercise
		solarSystem.advanceOneDay();
		
		// verify
		Position expectedPosition = new Position(Math.toRadians(-1));
		assertThat(solarSystem.positionOf(orbit).getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing90DaysThenFeringiOrbitShouldBeInMinus90Degrees() throws Exception {
		Orbit orbit = ferengiOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		
		// exercise
		for (int day = 1; day <= 90; day++) {
			solarSystem.advanceOneDay();
		}
		
		// verify
		Position expectedPosition = new Position(- (Math.PI / 2));
		assertThat(solarSystem.positionOf(orbit).getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancingOneDayThenVulcanoOrbitShouldAdvanceOneDegreeAnticlockwise() throws Exception {
		Orbit orbit = vulcanoOrbit;

		SolarSystem solarSystem = new SolarSystem(orbit);

		// exercise
		solarSystem.advanceOneDay();

		// verify
		Position expectedPosition = new Position(Math.toRadians(5));
		assertThat(solarSystem.positionOf(orbit).getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenAdvancing270DaysThenFeringiOrbitShouldBeIn90Degrees() throws Exception {
		Orbit orbit = ferengiOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		
		// exercise
		for (int day = 1; day <= 270; day++) {
			solarSystem.advanceOneDay();
		}
		
		// verify
		Position expectedPosition = new Position(Math.PI / 2);
		assertThat(solarSystem.positionOf(orbit).getRadians(), is(closeTo(expectedPosition.getRadians(), PRECISION)));
	}
	
	
	@Test
	public void whenAdvancing18DaysThenVulcanoOrbitShouldBeIn90Degrees() throws Exception {
		Orbit orbit = vulcanoOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		
		// exercise
		for (int day = 1; day <= 18; day++) {
			solarSystem.advanceOneDay();
		}
		
		// verify
		Position expectedPosition = new Position(Math.PI / 2);
		assertThat(solarSystem.positionOf(orbit).getRadians(), Matchers.is(Matchers.closeTo(expectedPosition.getRadians(), PRECISION)));
	}

	@Test
	public void whenCreatingASolarSystemPlanetsShouldBeAligned() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		assertTrue(solarSystem.orbitsAreAligned());
	}
	
	@Test
	public void whenCreatingASolarSystemShouldNotRain() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);

		assertFalse(solarSystem.isRaining());
	}

	private void assertPoint(SolarSystem solarSystem, Orbit orbit, Point2D expectedPoint) {
		Point2D newPoint = solarSystem.positionOf(orbit).getPoint();
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

