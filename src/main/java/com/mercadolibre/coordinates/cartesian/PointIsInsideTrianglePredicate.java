package com.mercadolibre.coordinates.cartesian;

import java.awt.geom.Point2D;

/**
 * Verifies if a given point is inside a Triangle defined by three other points.
 * 
 * @see http://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
 * @author emenendez
 *
 */
public class PointIsInsideTrianglePredicate {

	public static boolean evaluate(Point2D point, Point2D triangleVertex1, Point2D triangleVertex2, Point2D triangleVertex3) {
		if (noPairOfPointsInTheSameLine(point, triangleVertex1, triangleVertex2, triangleVertex3)) {
			return checkSigns(point, triangleVertex1, triangleVertex2, triangleVertex3);
		} else {
			return false;
		}
	}

	private static boolean noPairOfPointsInTheSameLine(Point2D origin, Point2D v1, Point2D v2, Point2D v3) {
		return !(sign(origin, v1, v2) == 0 && sign(origin, v2, v3) == 0);
	}

	private static boolean checkSigns(Point2D pt, Point2D v1, Point2D v2, Point2D v3) {
		boolean b1, b2, b3;

		b1 = sign(pt, v1, v2) < 0.0d;
		b2 = sign(pt, v2, v3) < 0.0d;
		b3 = sign(pt, v3, v1) < 0.0d;

		return ((b1 == b2) && (b2 == b3));
	}

	private static double sign(Point2D origin, Point2D v1, Point2D v2) {
		return (origin.getX() - v2.getX()) * (v1.getY() - v2.getY()) - (v1.getX() - v2.getX()) * (origin.getY() - v2.getY());
	}
	
}
