package com.mercadolibre.orbit;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.mercadolibre.orbit.Orbit;

public class OrbitAlignmentQueryTest {

	@Test
	public void positionsIn0RadiansShouldBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(0, 0, 0);
		
		Assert.assertTrue(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	@Test
	public void positionsInPiDivided2RadiansShouldBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(Math.PI / 2, Math.PI / 2, Math.PI / 2);
		
		Assert.assertTrue(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	@Test
	public void positionsInEquivalent0RadiansShouldBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(0, Math.PI * 2, Math.PI * 2);
		
		Assert.assertTrue(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	@Test
	public void positionsInEquivalentPiDivided2RadiansShouldBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(Math.PI / 2, Math.PI / 2, (3 * (Math.PI / 2)));
		
		Assert.assertTrue(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	@Test
	public void positionsInAnglesEquivalentTo60ShouldBeAligned() throws Exception {
		double first = Math.toRadians(60);
		double second = Math.toRadians(60 + 180);
		double third = Math.toRadians(60 + 360);
		Collection<Orbit> positions = createPositions(first, second, third);
		
		Assert.assertTrue(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	
	@Test
	public void onePositionDifferentThanTwoShouldNotBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(0, Math.PI / 2, Math.PI / 2);
		
		Assert.assertFalse(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	@Test
	public void allPositionsInDifferentRadiansShouldNotBeAligned() throws Exception {
		Collection<Orbit> positions = createPositions(0, Math.PI / 2, Math.PI);
		
		Assert.assertFalse(OrbitAlignmentQuery.orbitsAreAligned(positions));
	}

	
	private Collection<Orbit> createPositions(double... radians) {
		Collection<Orbit> positions = new ArrayList<>();
		
		for (double radian : radians) {
			positions.add(new Orbit(radian));
		}
		
		return positions;
	}
}
