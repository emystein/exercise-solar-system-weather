package com.mercadolibre.orbit.analysis;

import java.util.Collection;

import com.mercadolibre.orbit.Orbit;
import com.mercadolibre.orbit.OrbitAlignmentQuery;
import com.mercadolibre.orbit.SolarSystemEventType;

public class OrbitsAreAlignedToTheSunPredicate extends SolarSystemPredicate {

	public OrbitsAreAlignedToTheSunPredicate() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}

}
