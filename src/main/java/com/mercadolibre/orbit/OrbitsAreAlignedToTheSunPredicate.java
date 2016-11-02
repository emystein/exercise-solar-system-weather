package com.mercadolibre.orbit;

import java.util.Collection;

public class OrbitsAreAlignedToTheSunPredicate extends SolarSystemPredicate {

	public OrbitsAreAlignedToTheSunPredicate() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}

}
