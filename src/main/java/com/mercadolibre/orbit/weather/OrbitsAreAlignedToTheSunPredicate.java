package com.mercadolibre.orbit.weather;

import java.util.Collection;

import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.SolarSystemEventType;
import com.mercadolibre.orbit.SolarSystemPredicate;

public class OrbitsAreAlignedToTheSunPredicate extends SolarSystemPredicate {

	public OrbitsAreAlignedToTheSunPredicate() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}

}
