package com.mercadolibre.orbit;

public class Orbit {

	private int distanceToSun;
	private double angularSpeed;

	public Orbit(int distanceToSun, int traslationAnglePerDay) {
		this.distanceToSun = distanceToSun;
		this.angularSpeed = Math.toRadians(traslationAnglePerDay);
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
	
}
