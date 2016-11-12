package com.kamikaze.solarsystem.weather.analysis;

import java.awt.geom.Point2D;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.kamikaze.coordinates.Triangle;
import com.kamikaze.solarsystem.Orbit;
import com.kamikaze.solarsystem.weather.Weather;

@Component
public class IsRainingAnalysis extends WeatherAnalysis {

	private double rainFactor;

	public IsRainingAnalysis() {
		super(Weather.Rain);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		Point2D pointOfTheSun = new Point2D.Double(0, 0);
		
		List<Point2D> orbitPoints = orbits.stream().map(orbit -> orbit.getCoordinates()).collect(Collectors.toList());
		
		Triangle triangle = new Triangle(orbitPoints);

		rainFactor = triangle.getPerimeter();
		
		return rainFactor > 0d && triangle.containsPoint(pointOfTheSun);
	}

	public double getValue() {
		return rainFactor;
	}

}
