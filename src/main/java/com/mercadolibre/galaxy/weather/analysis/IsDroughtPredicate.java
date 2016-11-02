package com.mercadolibre.galaxy.weather.analysis;

import java.util.Collection;

import org.springframework.stereotype.Component;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

@Component
public class IsDroughtPredicate extends SolarSystemPredicate {

	public IsDroughtPredicate() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitsAlignedToTheSunPredicate.matches(orbits);
	}

}
