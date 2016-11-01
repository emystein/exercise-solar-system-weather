package com.mercadolibre.geometry;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;

import com.mercadolibre.geometry.Position;
import com.mercadolibre.geometry.PositionAlignmentQuery;

public class PositionAlignmentQueryTest {

	@Test
	public void positionsIn0RadiansShouldBeAligned() throws Exception {
		Collection<Position> positions = createPositions(0, 0, 0);
		
		Assert.assertTrue(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	@Test
	public void positionsInPiDivided2RadiansShouldBeAligned() throws Exception {
		Collection<Position> positions = createPositions(Math.PI / 2, Math.PI / 2, Math.PI / 2);
		
		Assert.assertTrue(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	@Test
	public void positionsInEquivalent0RadiansShouldBeAligned() throws Exception {
		Collection<Position> positions = createPositions(0, Math.PI * 2, Math.PI * 2);
		
		Assert.assertTrue(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	@Test
	public void positionsInEquivalentPiDivided2RadiansShouldBeAligned() throws Exception {
		Collection<Position> positions = createPositions(Math.PI / 2, Math.PI / 2, (3 * (Math.PI / 2)));
		
		Assert.assertTrue(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	@Test
	public void positionsInAnglesEquivalentTo60ShouldBeAligned() throws Exception {
		double first = Math.toRadians(60);
		double second = Math.toRadians(60 + 180);
		double third = Math.toRadians(60 + 360);
		Collection<Position> positions = createPositions(first, second, third);
		
		Assert.assertTrue(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	
	@Test
	public void onePositionDifferentThanTwoShouldNotBeAligned() throws Exception {
		Collection<Position> positions = createPositions(0, Math.PI / 2, Math.PI / 2);
		
		Assert.assertFalse(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	@Test
	public void allPositionsInDifferentRadiansShouldNotBeAligned() throws Exception {
		Collection<Position> positions = createPositions(0, Math.PI / 2, Math.PI);
		
		Assert.assertFalse(PositionAlignmentQuery.positionsAreAligned(positions));
	}

	
	private Collection<Position> createPositions(double... radians) {
		Collection<Position> positions = new ArrayList<>();
		
		for (double radian : radians) {
			positions.add(new Position(radian));
		}
		
		return positions;
	}
}
