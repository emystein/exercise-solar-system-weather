package com.mercadolibre.coordinates;

import java.awt.geom.Point2D;

public class TriangleArea {
	public static double calculate(Point2D a, Point2D b, Point2D c) {
		return Math.abs(((a.getX() * (b.getY() - c.getY())) + (b.getX() * (c.getY() - a.getY())) + (c.getX() * (a.getY() - b.getY()))) / 2);
	}
}
