package com.mercadolibre.orbit;

import java.util.HashMap;
import java.util.Map;

public class SolarSystem {

	private Orbit[] orbits;
	private Map<Orbit, Position> positions = new HashMap<>();

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

	public boolean orbitsAreAligned() {
		return PositionAlignmentQuery.positionsAreAligned(positions.values());
	}
}
