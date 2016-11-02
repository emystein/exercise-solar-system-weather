package com.mercadolibre.orbit.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import com.mercadolibre.coordinates.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.TriangleArea;
import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.SolarSystemEventType;

public class IsRainingPredicate extends SolarSystemPredicate {

	private Point2D pointOfTheSun;
	private double rainArea;

	public IsRainingPredicate(Point2D pointOfTheSun) {
		super(SolarSystemEventType.RAIN);
		this.pointOfTheSun = pointOfTheSun;
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		Iterator<Orbit> iterator = orbits.iterator();

		Point2D point1 = iterator.next().getCoordinates();
		Point2D point2 = iterator.next().getCoordinates();
		Point2D point3 = iterator.next().getCoordinates();

		rainArea = TriangleArea.calculate(point1, point2, point3);

		return rainArea > 0d && PointIsInsideTrianglePredicate.matches(pointOfTheSun, point1, point2, point3);
	}

	public double getValue() {
		return rainArea;
	}

}
