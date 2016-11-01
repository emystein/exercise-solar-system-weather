package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;
import java.awt.geom.Point2D;

import org.junit.Test;

public class SolarSystemTest {
	private Orbit ferengiOrbit = new Orbit(500, -1);
	private Orbit betasoideOrbit = new Orbit(2000, -3);
	private Orbit vulcanoOrbit = new Orbit(1000, 1);

	@Test
	public void whenCreatingASolarSystemPositionOfOrbitsShould0AndDistanceToSun() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		
		assertThat(solarSystem.positionOf(ferengiOrbit), is(new Point(500, 0))); 
		assertThat(solarSystem.positionOf(betasoideOrbit), is(new Point(2000, 0))); 
		assertThat(solarSystem.positionOf(vulcanoOrbit), is(new Point(1000, 0))); 
	}
	
	@Test
	public void whenAdvancingOneDayThenFerengiOrbitShouldAdvanceOneDegreeClockwise() throws Exception {
		Orbit orbit = ferengiOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		Point2D oldPoint = solarSystem.positionOf(orbit);

		// exercise
		solarSystem.advanceOneDay();
		
		Point2D expectedPoint = getNewPointAfterMovingOrbit(orbit, oldPoint);
		
		assertThat(solarSystem.positionOf(orbit), is(expectedPoint));
	}

	@Test
	public void whenAdvancingOneDayThenVulcanoOrbitShouldAdvanceOneDegreeAnticlockwise() throws Exception {
		Orbit orbit = vulcanoOrbit;
		
		SolarSystem solarSystem = new SolarSystem(orbit);
		Point2D oldPoint = solarSystem.positionOf(orbit);
		
		// exercise
		solarSystem.advanceOneDay();
		
		// verify
		Point2D expectedPoint = getNewPointAfterMovingOrbit(orbit, oldPoint);
		
		assertThat(solarSystem.positionOf(orbit), is(expectedPoint));
	}

	private Point2D getNewPointAfterMovingOrbit(Orbit orbit, Point2D oldPoint) {
		double deltaAngle = orbit.getAngularSpeedPerDay();
		double newX = orbit.getDistanceToSun() * Math.cos(deltaAngle);
		double newY = oldPoint.getY() + (orbit.getDistanceToSun() * Math.sin(deltaAngle));
		Point2D expectedPoint = new Point2D.Double(newX, newY);
		return expectedPoint;
	}
}

