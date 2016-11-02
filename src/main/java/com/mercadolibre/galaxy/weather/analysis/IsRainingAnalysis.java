package com.mercadolibre.galaxy.weather.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mercadolibre.coordinates.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.TriangleArea;
import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

@Component
@Scope("request")
public class IsRainingAnalysis extends SolarSystemAnalysis {

	private double rainArea;

	public IsRainingAnalysis() {
		super(SolarSystemEventType.RAIN);
	}

	@Override
	boolean matches(Collection<Orbit> orbits) {
		Point2D pointOfTheSun = new Point2D.Double(0, 0);

		Iterator<Orbit> iterator = orbits.iterator();

		Point2D point1 = iterator.next().getCoordinates();
		Point2D point2 = iterator.next().getCoordinates();
		Point2D point3 = iterator.next().getCoordinates();

		rainArea = TriangleArea.calculate(point1, point2, point3);

		return rainArea > 0d && PointIsInsideTrianglePredicate.matches(pointOfTheSun, point1, point2, point3);
	}

	double getValue() {
		return rainArea;
	}

}
