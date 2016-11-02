package com.mercadolibre.orbit.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import com.mercadolibre.coordinates.PointIsInsideTrianglePredicate;
import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.SolarSystemEventType;

public class IsRainingPredicate extends SolarSystemPredicate {

	private Point2D pointOfTheSun;

	public IsRainingPredicate(Point2D pointOfTheSun) {
		super(SolarSystemEventType.RAIN);
		this.pointOfTheSun = pointOfTheSun;
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();

		return PointIsInsideTrianglePredicate.matches(pointOfTheSun, p1, p2, p3);
	}

}
