package com.mercadolibre.geometry;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class Position {
	double REVOLUTION = Math.PI * 2;
	
	private Double point;
	private double radians;

	public Position(double radians, double x, double y) {
		this(radians);
		point = new Point2D.Double(x, y);
	}

	public Position(double radians) {
		if (radians < 0) {
			radians = REVOLUTION + radians;
		}
		
		if (radians >= REVOLUTION) {
			this.radians = radians - REVOLUTION;
		} else {
			this.radians = radians;
		}
	}

	public double getRadians() {
		return this.radians;
	}

	public Point2D getPoint() {
		return point;
	}
}
