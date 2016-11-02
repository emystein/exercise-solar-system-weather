package com.mercadolibre.galaxy;

import java.awt.geom.Point2D;

public class Orbit {
	private static double REVOLUTION = Math.PI * 2;
	// 1 degree = 0.0174 rads
	private static final double ONE_DEGREE_RADIANS_PRECISION = 0.0174d;

	// radius
	private int distanceToSun;
	private double radians;
	private double angularSpeedPerDay;

	public Orbit(int distanceToSun, int traslationAnglePerDay) {
		this(distanceToSun, traslationAnglePerDay, 0);
	}

	public Orbit(int distanceToSun, int traslationAnglePerDay, double radians) {
		this(radians);
		this.distanceToSun = distanceToSun;
		this.angularSpeedPerDay = Math.toRadians(traslationAnglePerDay);
	}

	public Orbit(double radians) {
		setRadians(radians);
	}

	public int getDistanceToSun() {
		return distanceToSun;
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

	/**
	 * @return radians / day
	 */
	public double getAngularSpeedPerDay() {
		return angularSpeedPerDay;
	}
	
	
	public Point2D getCoordinates() {
		double x = round(distanceToSun * Math.cos(radians));
		double y = round(distanceToSun * Math.sin(radians));
		return new Point2D.Double(x, y);
	}

	public void moveDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			this.setRadians(getRadians() + getAngularSpeedPerDay());
		}
	}

	private double round(double value) {
		return (double) Math.round(value * 10000d) / 10000d;
	}

}
