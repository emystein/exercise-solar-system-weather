package com.kamikaze.solarsystem.weather.analysis;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.kamikaze.solarsystem.Orbit;
import com.kamikaze.solarsystem.weather.Weather;

/**
 * Matches if orbits are aligned to the sun.
 * @author emenendez
 *
 */
@Component
public class IsDroughtAnalysis extends WeatherAnalysis {
	// precision of 1 degree = 0.0174 rads
	private static final double ONE_DEGREE_RADIANS_PRECISION = 0.0174d;

	public IsDroughtAnalysis() {
		super(Weather.Drought);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		double initialRadians = moveToFirstQuadrant(orbits.iterator().next().getRadians());
		double initialTan = Math.tan(initialRadians);

		return orbits.stream().map(position -> position.getRadians()).map(radians -> moveToFirstQuadrant(radians))
				.allMatch(radians -> roundedTanMatches(radians, initialTan));

	}

	private double moveToFirstQuadrant(double radians) {
		while (radians > Math.PI / 2) {
			radians -= Math.PI / 2;
		}

		return radians;
	}

	private boolean roundedTanMatches(double currentRadians, double initialTan) {
		return Math.abs((Math.tan(currentRadians) - initialTan)) <= ONE_DEGREE_RADIANS_PRECISION;
	}

}
