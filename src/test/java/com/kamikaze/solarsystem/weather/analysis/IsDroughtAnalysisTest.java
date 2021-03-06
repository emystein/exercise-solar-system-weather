package com.kamikaze.solarsystem.weather.analysis;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.kamikaze.solarsystem.Orbit;
import com.kamikaze.solarsystem.SolarSystemTestSupport;
import com.kamikaze.solarsystem.weather.analysis.IsDroughtAnalysis;
import com.kamikaze.solarsystem.weather.analysis.WeatherAnalysis;

public class IsDroughtAnalysisTest extends SolarSystemTestSupport {

	private WeatherAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new IsDroughtAnalysis();
	}

	@Test
	public void positionsIn0RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(0, 0, 0);
		
		assertTrue(analysis.matches(orbits));
	}

	@Test
	public void positionsInPiDivided2RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(Math.PI / 2, Math.PI / 2, Math.PI / 2);
		
		assertTrue(analysis.matches(orbits));
	}

	@Test
	public void positionsInEquivalent0RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI * 2, Math.PI * 2);
		
		assertTrue(analysis.matches(orbits));
	}

	@Test
	public void positionsInEquivalentPiDivided2RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(Math.PI / 2, Math.PI / 2, (3 * (Math.PI / 2)));
		
		assertTrue(analysis.matches(orbits));
	}

	@Test
	public void positionsInAnglesEquivalentTo60ShouldBeAligned() throws Exception {
		double first = Math.toRadians(60);
		double second = Math.toRadians(60 + 180);
		double third = Math.toRadians(60 + 360);
		orbits = createPositions(first, second, third);
		
		assertTrue(analysis.matches(orbits));
	}

	
	@Test
	public void onePositionDifferentThanTwoShouldNotBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI / 2, Math.PI / 2);

		assertFalse(analysis.matches(orbits));
	}

	@Test
	public void allPositionsInDifferentRadiansShouldNotBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI / 2, Math.PI);
		
		assertFalse(analysis.matches(orbits));
	}

	private Collection<Orbit> createPositions(double... radians) {
		Collection<Orbit> orbits = new ArrayList<>();
		
		for (double radian : radians) {
			orbits.add(new Orbit(radian));
		}
		
		return orbits;
	}

}
