package com.mercadolibre.orbit;

public class Orbit {

	// 2 Pi rad / 1 day (in seconds)
	private static double radsPerDay = Math.PI * 2 / 86400;
	
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
