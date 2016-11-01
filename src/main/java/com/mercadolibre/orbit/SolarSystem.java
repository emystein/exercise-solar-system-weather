package com.mercadolibre.orbit;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.HashMap;
import java.util.Map;

public class SolarSystem {

	private Orbit[] orbits;
	private Map<Orbit, Point2D> positions = new HashMap<>();

	public SolarSystem(Orbit...orbits) {
		this.orbits = orbits;
		
		for (Orbit orbit : orbits) {
			addPosition(orbit);
		}
	}

	private void addPosition(Orbit orbit) {
		positions.put(orbit, new Point2D.Double(orbit.getDistanceToSun(), 0));
	}

	public Orbit[] getOrbits() {
		return orbits;
	}

	public Point2D positionOf(Orbit orbit) {
		return positions.get(orbit);
	}

	public void advanceOneDay() {
		for (Orbit orbit : orbits) {
			Point2D point = positions.get(orbit);
			Point2D newPoint = movePointUsingAngularSpeed(orbit, point);
			positions.put(orbit, newPoint);
		}
	}

	private Double movePointUsingAngularSpeed(Orbit orbit, Point2D point) {
		double atan2 = Math.atan2(point.getY(), point.getX());
		double newX = orbit.getDistanceToSun() * Math.cos(atan2 + orbit.getAngularSpeedPerDay());
		double newY = point.getY() + (orbit.getDistanceToSun() * Math.sin(atan2 + orbit.getAngularSpeedPerDay()));
		return new Point2D.Double(newX, newY);
	}

}
