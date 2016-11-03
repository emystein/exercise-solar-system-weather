package com.mercadolibre.coordinates;

import java.awt.geom.Point2D;
import java.util.List;

public class Triangle {
	private Point2D a, b, c;

	public Triangle(Point2D... points) {
		this.a = points[0];
		this.b = points[1];
		this.c = points[2];
	}

	public Triangle(List<Point2D> points) {
		this(points.get(0), points.get(1), points.get(2));
	}

	public double getPerimeter() {
		return getDistance(a, b) + getDistance(b, c) + getDistance(c, a);
	}

	public double getArea() {
		double s = getPerimeter() / 2;
		double d1 = (s - getDistance(a, b));
		double d2 = (s - getDistance(b, c));
		double d3 = (s - getDistance(c, a));
		return Math.sqrt(s * d1 * d2 * d3);
	}

	private double getDistance(Point2D p1, Point2D p2) {
		double dX = (p1.getX() - p2.getX());
		double dY = (p1.getY() - p2.getY());
		return Math.sqrt(dX * dX + dY * dY);
	}

	// See
	// http://stackoverflow.com/questions/2049582/how-to-determine-if-a-point-is-in-a-2d-triangle
	public boolean containsPoint(Point2D point) {
		return noPairOfPointsInTheSameLine(point, a, b, c) && checkSigns(point, a, b, c);
	}

	private boolean noPairOfPointsInTheSameLine(Point2D origin, Point2D p1, Point2D p2, Point2D p3) {
		return !(sign(origin, p1, p2) == 0 && sign(origin, p2, p3) == 0);
	}

	private boolean checkSigns(Point2D origin, Point2D p1, Point2D p2, Point2D p3) {
		boolean b1, b2, b3;

		b1 = sign(origin, p1, p2) < 0.0d;
		b2 = sign(origin, p2, p3) < 0.0d;
		b3 = sign(origin, p3, p1) < 0.0d;

		return ((b1 == b2) && (b2 == b3));
	}

	private double sign(Point2D origin, Point2D v1, Point2D v2) {
		return (origin.getX() - v2.getX()) * (v1.getY() - v2.getY())
				- (v1.getX() - v2.getX()) * (origin.getY() - v2.getY());
	}

}