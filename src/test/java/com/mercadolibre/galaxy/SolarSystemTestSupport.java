package com.mercadolibre.galaxy;

import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;

import com.mercadolibre.galaxy.weather.analysis.IsDroughtAnalysis;
import com.mercadolibre.galaxy.weather.analysis.IsRainingAnalysis;
import com.mercadolibre.galaxy.weather.analysis.OptimalPreasureAndTemperatureAnalysis;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemAnalysis;

public class SolarSystemTestSupport {
	protected Orbit ferengiOrbit = new Orbit(500, -1);
	protected Orbit betasoideOrbit = new Orbit(2000, -3);
	protected Orbit vulcanoOrbit = new Orbit(1000, 5);

	protected Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	protected SolarSystem solarSystem;

	@Before
	public void setUp() throws Exception {
		Collection<SolarSystemAnalysis> weatherAnalysisPredicates = new ArrayList<>();
		weatherAnalysisPredicates.add(new IsDroughtAnalysis());
		weatherAnalysisPredicates.add(new IsRainingAnalysis());
		weatherAnalysisPredicates.add(new OptimalPreasureAndTemperatureAnalysis());

		solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates);
	}
}
