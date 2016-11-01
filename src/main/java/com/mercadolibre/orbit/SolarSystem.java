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

	// TODO: move to SolarTime class?
	public void advanceOneDay() {
		for (Orbit orbit : orbits) {
			Point2D currentPointOfOrbit = positions.get(orbit);
			Point2D newPoint = movePointUsingAngularSpeed(orbit, currentPointOfOrbit);
			positions.put(orbit, newPoint);
		}
	}

	// TODO: move to Orbit together with orbit's position?
	private Double movePointUsingAngularSpeed(Orbit orbit, Point2D point) {
		double atan2 = Math.atan2(point.getY(), point.getX());
		double newX = orbit.getDistanceToSun() * Math.cos(atan2 + orbit.getAngularSpeedPerDay());
		double newY = point.getY() + (orbit.getDistanceToSun() * Math.sin(atan2 + orbit.getAngularSpeedPerDay()));
		return new Point2D.Double(newX, newY);
	}

}
