package com.mercadolibre.galaxy.weather.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.mercadolibre.coordinates.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.TriangleArea;
import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

@Component
public class IsRainingPredicate extends SolarSystemPredicate {

	private Point2D pointOfTheSun = new Point2D.Double(0, 0);
	private double rainArea;

	public IsRainingPredicate() {
		super(SolarSystemEventType.RAIN);
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
