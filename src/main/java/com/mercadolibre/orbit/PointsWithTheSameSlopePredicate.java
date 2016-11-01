package com.mercadolibre.orbit;

import java.awt.geom.Point2D;

public class PointsWithTheSameSlopePredicate {

	public static boolean evaluate(Point2D p1, Point2D p2, Point2D p3) {
		double slopeP1P2 = slope(p1, p2);
		double slopeP2P3 = slope(p2, p3);
		
		return slopeP1P2 == slopeP2P3;
	}

	private static double slope(Point2D p1, Point2D p2) {
		return Math.abs((p2.getY() - p1.getY()) / (p2.getX() - p1.getX()));
	}

}
