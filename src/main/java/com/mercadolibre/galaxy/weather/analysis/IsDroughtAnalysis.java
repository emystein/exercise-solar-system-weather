package com.mercadolibre.galaxy.weather.analysis;

import java.util.Collection;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

@Component
@Scope("request")
public class IsDroughtAnalysis extends SolarSystemAnalysis {

	public IsDroughtAnalysis() {
		super(SolarSystemEventType.DROUGHT);
	}

	@Override
	public boolean matches(Collection<Orbit> orbits) {
		return OrbitsAlignedToTheSunPredicate.matches(orbits);
	}

}
