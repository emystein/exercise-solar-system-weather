package com.mercadolibre.galaxy.weather.analysis;

import java.util.Collection;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public class OrbitsAreAlignedToTheSunPredicate extends SolarSystemPredicate {

	public OrbitsAreAlignedToTheSunPredicate() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}

}
