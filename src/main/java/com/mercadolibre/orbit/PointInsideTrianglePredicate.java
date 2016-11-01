package com.mercadolibre.orbit;

import java.awt.geom.Point2D;

/**
 * Verifies if a given point is inside a Triangle defined by three other points.
 * 
 * @see http://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
 * @author emenendez
 *
 */
public class PointInsideTrianglePredicate {

	public static boolean evaluate(Point2D pt, Point2D v1, Point2D v2, Point2D v3) {
		boolean b1, b2, b3;

		b1 = sign(pt, v1, v2) < 0.0d;
		b2 = sign(pt, v2, v3) < 0.0d;
		b3 = sign(pt, v3, v1) < 0.0d;

		return ((b1 == b2) && (b2 == b3));
	}

	private static double sign(Point2D p1, Point2D p2, Point2D p3) {
		return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
	}
	
}
