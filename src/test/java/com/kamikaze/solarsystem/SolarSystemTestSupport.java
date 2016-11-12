package com.kamikaze.solarsystem;

import java.util.ArrayList;
import java.util.Collection;

import org.assertj.core.util.Lists;
import org.junit.Before;

import com.kamikaze.solarsystem.Orbit;
import com.kamikaze.solarsystem.SolarSystem;
import com.kamikaze.solarsystem.weather.analysis.IsDroughtAnalysis;
import com.kamikaze.solarsystem.weather.analysis.IsRainingAnalysis;
import com.kamikaze.solarsystem.weather.analysis.OptimalPreasureAndTemperatureAnalysis;
import com.kamikaze.solarsystem.weather.analysis.WeatherAnalysis;

public class SolarSystemTestSupport {
	protected Orbit ferengiOrbit = new Orbit(500, -1);
	protected Orbit betasoideOrbit = new Orbit(2000, -3);
	protected Orbit vulcanoOrbit = new Orbit(1000, 5);

	protected Collection<Orbit> orbits = Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	
	protected SolarSystem solarSystem;

	@Before
	public void setUp() throws Exception {
		Collection<WeatherAnalysis> weatherAnalysisPredicates = new ArrayList<>();
		weatherAnalysisPredicates.add(new IsDroughtAnalysis());
		weatherAnalysisPredicates.add(new IsRainingAnalysis());
		weatherAnalysisPredicates.add(new OptimalPreasureAndTemperatureAnalysis());

		solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates);
	}
}
