package com.mercadolibre.galaxy.weather.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.Iterator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mercadolibre.coordinates.PointsHasSameSlopePredicate;
import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.weather.Weather;

@Component
@Scope("request")
public class OptimalPreasureAndTemperatureAnalysis extends WeatherAnalysis {

	public OptimalPreasureAndTemperatureAnalysis() {
		super(Weather.OptimalPreasureAndTemperature);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();

		return !orbitsAreAlignedToTheSun(orbits) && PointsHasSameSlopePredicate.matches(p1, p2, p3);
	}

	public boolean orbitsAreAlignedToTheSun(Collection<Orbit> orbits) {
		IsDroughtAnalysis droughtAnalysis = new IsDroughtAnalysis();
		return droughtAnalysis.matches(orbits);
	}
}
