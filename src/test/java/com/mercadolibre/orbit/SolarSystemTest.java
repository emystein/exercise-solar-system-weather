package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.awt.Point;
import java.awt.geom.Point2D;

import org.junit.Test;

public class SolarSystemTest {
	private Orbit ferengiOrbit = new Orbit(500, 1);
	private Orbit betasoideOrbit = new Orbit(2000, 3);
	private Orbit vulcanoOrbit = new Orbit(1000, -1);

	@Test
	public void whenCreatingASolarSystemPositionOfOrbitsShould0AndDistanceToSun() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		
		assertThat(solarSystem.positionOf(ferengiOrbit), is(new Point(500, 0))); 
		assertThat(solarSystem.positionOf(betasoideOrbit), is(new Point(2000, 0))); 
		assertThat(solarSystem.positionOf(vulcanoOrbit), is(new Point(1000, 0))); 
	}
	
	@Test
	public void whenAdvancingOneDayThenFerengiOrbitShouldBeOneDegreeUpper() throws Exception {
		SolarSystem solarSystem = new SolarSystem(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
		Point2D oldPoint = solarSystem.positionOf(ferengiOrbit);

		solarSystem.advanceOneDay();
		
		double oneDegreeInRadians = Math.toRadians(1);		
		double newX = ferengiOrbit.getDistanceToSun() * Math.cos(oneDegreeInRadians);
		double newY = oldPoint.getY() + (ferengiOrbit.getDistanceToSun() * Math.sin(oneDegreeInRadians));
		Point2D expectedPoint = new Point2D.Double(newX, newY);
		
		assertThat(solarSystem.positionOf(ferengiOrbit), is(expectedPoint));
	}
}

