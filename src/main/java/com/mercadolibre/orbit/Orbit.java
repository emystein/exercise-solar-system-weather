package com.mercadolibre.orbit;

import java.awt.geom.Point2D;

import com.mercadolibre.coordinates.position.Position;

// TODO: Merge Position into this class
public class Orbit {
	private Position position;
	private int distanceToSun;
	private double angularSpeed;

	public Orbit(int distanceToSun, int traslationAnglePerDay) {
		this.distanceToSun = distanceToSun;
		this.angularSpeed = Math.toRadians(traslationAnglePerDay);
		this.position = new Position(distanceToSun, 0);
	}

	// radio
	public int getDistanceToSun() {
		return distanceToSun;
	}

	/**
	 * @return radians / day
	 */
	public double getAngularSpeedPerDay() {
		return angularSpeed;
	}

	public void moveDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			this.position.setRadians(position.getRadians() + getAngularSpeedPerDay());
		}
	}

	public Point2D getCoordinates() {
		return this.position.getCoordinates();
	}

}
