package com.mercadolibre.orbit;

import java.awt.geom.Point2D;
import java.util.HashMap;
import java.util.Map;

import com.mercadolibre.coordinates.cartesian.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.cartesian.PointsHasSameSlopePredicate;
import com.mercadolibre.coordinates.position.Position;
import com.mercadolibre.coordinates.position.PositionAlignmentQuery;

public class SolarSystem {

	private Orbit[] orbits;
	private Map<Orbit, Position> positions = new HashMap<>();
	private Point2D pointOfTheSun = new Point2D.Double(0, 0);

	public SolarSystem(Orbit...orbits) {
		this.orbits = orbits;
		
		for (Orbit orbit : orbits) {
			addPosition(orbit);
		}
	}

	private void addPosition(Orbit orbit) {
		Position position = new Position(orbit.getDistanceToSun(), 0);
		positions.put(orbit, position);
	}

	public Orbit[] getOrbits() {
		return orbits;
	}

	public Position positionOf(Orbit orbit) {
		return positions.get(orbit);
	}

	// TODO: move to SolarTime class?
	public void advanceOneDay() {
		for (Orbit orbit : orbits) {
			Position currentPointOfOrbit = positions.get(orbit);
			Position newPoint = movePointUsingAngularSpeed(orbit, currentPointOfOrbit);
			positions.put(orbit, newPoint);
		}
	}

	// TODO: move to Orbit together with orbit's position?
	private Position movePointUsingAngularSpeed(Orbit orbit, Position position) {
		return new Position(position.getRadians() + orbit.getAngularSpeedPerDay());
	}

	public boolean orbitsAreAlignedToTheSun() {
		return PositionAlignmentQuery.positionsAreAligned(positions.values());
	}
	
	public boolean isRaining() {
		Point2D p1 = positions.get(orbits[0]).getCoordinates();
		Point2D p2 = positions.get(orbits[1]).getCoordinates();
		Point2D p3 = positions.get(orbits[2]).getCoordinates();
		
		return PointIsInsideTrianglePredicate.evaluate(pointOfTheSun, p1, p2, p3);
	}

	public boolean optimalConditionsOfPreasureAndTemperature() {
		Point2D p1 = positions.get(orbits[0]).getCoordinates();
		Point2D p2 = positions.get(orbits[1]).getCoordinates();
		Point2D p3 = positions.get(orbits[2]).getCoordinates();
		
		return !orbitsAreAlignedToTheSun() && PointsHasSameSlopePredicate.evaluate(p1, p2, p3);
	}
}
