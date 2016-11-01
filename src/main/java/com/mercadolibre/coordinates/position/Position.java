package com.mercadolibre.coordinates.position;

import java.awt.geom.Point2D;

public class Position {
	private static double REVOLUTION = Math.PI * 2;
	// 1 degree = 0.0174 rads
	private static final double ONE_DEGREE_RADIANS_PRECISION = 0.0174d;

	private double radius;
	private double radians;

	public Position(double radius, double radians) {
		this(radians);
		this.radius = radius;
	}
	
	public Position(double radians) {
		setRadians(radians);
	}

	public double getRadians() {
		return this.radians;
	}

	public void setRadians(double radians) {
		if (radians < 0) {
			radians = REVOLUTION + radians;
		}
		
		if (radians >= REVOLUTION) {
			this.radians = radians - REVOLUTION;
		} else {
			this.radians = radians;
		}
	}

	public Point2D getCoordinates() {
		double x = round(radius * Math.cos(radians));
		double y = round(radius * Math.sin(radians));
		return new Point2D.Double(x, y);
	}

	private double round(double value) {
		return (double)Math.round(value * 10000d) / 10000d;
	}

}
