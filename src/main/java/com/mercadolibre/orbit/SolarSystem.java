package com.mercadolibre.orbit;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import com.mercadolibre.coordinates.cartesian.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.cartesian.PointsHasSameSlopePredicate;

public class SolarSystem {

	private Collection<Orbit> orbits;
	private Point2D pointOfTheSun = new Point2D.Double(0, 0);

	public SolarSystem(Collection<Orbit> orbits) {
		this.orbits = orbits;
	}

	public Collection<Orbit> getOrbits() {
		return orbits;
	}

	// TODO: move to SolarTime class?
	public void advanceOneDay() {
		for (Orbit orbit : orbits) {
			orbit.moveDays(1);
		}
	}

	public boolean orbitsAreAlignedToTheSun() {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}
	
	public boolean isRaining() {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();
		
		return PointIsInsideTrianglePredicate.evaluate(pointOfTheSun, p1, p2, p3);
	}

	public boolean optimalConditionsOfPreasureAndTemperature() {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();
		
		return !orbitsAreAlignedToTheSun() && PointsHasSameSlopePredicate.evaluate(p1, p2, p3);
	}
}
