package com.mercadolibre.galaxy;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.google.common.collect.Lists;
import com.mercadolibre.galaxy.event.SolarSystemEventCollector;
import com.mercadolibre.galaxy.weather.analysis.IsDroughtPredicate;
import com.mercadolibre.galaxy.weather.analysis.IsRainingPredicate;
import com.mercadolibre.galaxy.weather.analysis.OptimalPreasureAndTemperaturePredicate;
import com.mercadolibre.galaxy.weather.analysis.SolarSystemPredicate;
import com.mercadolibre.galaxy.weather.report.WeatherQuery;

@Configuration
public class ApplicationConfig {
	@Bean
	@Scope("request")
	public Collection<Orbit> orbits() {
		Orbit ferengiOrbit = new Orbit(500, -1);
		Orbit betasoideOrbit = new Orbit(2000, -3);
		Orbit vulcanoOrbit = new Orbit(1000, 5);
		
		return Lists.newArrayList(ferengiOrbit, betasoideOrbit, vulcanoOrbit);
	}

	@Bean
	@Scope("request")
	public IsDroughtPredicate isDroughtPredicate() {
		return new IsDroughtPredicate();
	}

	@Bean
	@Scope("request")
	public SolarSystemPredicate isRainingPredicate() {
		return new IsRainingPredicate();
	}
	
	@Bean
	@Scope("request")
	public SolarSystemPredicate optimalPreasureAndTemperaturePredicate() {
		return new OptimalPreasureAndTemperaturePredicate();
	}
	
	@Bean
	@Scope("request")
	public SolarSystemEventCollector solarSystemEventCollector() {
		return new SolarSystemEventCollector();
	}

	@Bean
	@Scope("request")
	public SolarSystem solarSystem(Collection<Orbit> orbits, Collection<SolarSystemPredicate> weatherAnalysisPredicates, SolarSystemEventCollector solarSystemEventCollector) {
		SolarSystem solarSystem = new SolarSystem(orbits, weatherAnalysisPredicates);
		solarSystem.registerObserver(solarSystemEventCollector);
		return solarSystem;
	}
	
	@Bean
	@Scope("request")
	public WeatherQuery weatherQuery(SolarSystem solarSystem, SolarSystemEventCollector solarSystemEventCollector) {
		return new WeatherQuery(solarSystem, solarSystemEventCollector);
	}
}
