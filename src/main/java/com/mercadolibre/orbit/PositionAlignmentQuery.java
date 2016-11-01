package com.mercadolibre.orbit;

import java.util.Collection;

// TODO: rename to PositionAlignmentPredicate (rename test too)
public class PositionAlignmentQuery {
	// 1 degree = 0.0174 rads
	private static final double ONE_DEGREE_RADIANS_PRECISION = 0.0174d;

	public static boolean positionsAreAligned(Collection<Position> positions) {
		double initialRadians = moveToFirstQuadrant(positions.iterator().next().getRadians());
		double initialTan = Math.tan(initialRadians);
		
		return positions.stream()
				.map(position -> position.getRadians())
				.map(radians -> moveToFirstQuadrant(radians))
				.allMatch(radians -> roundedTanMatches(radians, initialTan));
		
	}
	
	private static double moveToFirstQuadrant(double radians) {
		while (radians > Math.PI / 2) {
			radians -= Math.PI / 2;
		}
		
		return radians;
	}

	private static boolean roundedTanMatches(double currentRadians, double initialTan) {
		return Math.abs((Math.tan(currentRadians) - initialTan)) <= ONE_DEGREE_RADIANS_PRECISION;
	}
}
