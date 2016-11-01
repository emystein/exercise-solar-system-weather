package com.mercadolibre.orbit;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mercadolibre.coordinates.cartesian.PointIsInsideTrianglePredicate;
import com.mercadolibre.coordinates.cartesian.PointsHasSameSlopePredicate;

public class SolarSystem {
	private static final Logger logger = LoggerFactory.getLogger(SolarSystem.class);

	private Collection<Orbit> orbits;
	private Point2D pointOfTheSun = new Point2D.Double(0, 0);
	private Collection<SolrSystemObserver> observers = new ArrayList<>();

	public SolarSystem(Collection<Orbit> orbits) {
		this.orbits = orbits;
	}

	public Collection<Orbit> getOrbits() {
		return orbits;
	}

	// TODO: move to SolarTime class?
	public void advanceDays(int numberOfDays) {
		for (int day = 1; day <= numberOfDays; day++) {
			for (Orbit orbit : orbits) {
				orbit.moveDays(1);
				try {
					this.generateEvents(day);
				} catch (Exception e) {
					// TODO: logger.error("Day {}. Erro: {}", day, e.getMessage());
					System.out.println("Day: " + day + ". Error: " + e.getMessage());
				}
			}
		}
	}

	// TODO: extract event listener logic
	private void generateEvents(int day) {
		List<SolrSystemEvent> events = new ArrayList<>();
		
		if (orbitsAreAlignedToTheSun()) {
			events.add(new SolrSystemEvent(day, SolrSystemEventType.DROUGHT)); 
		}
		
		if (isRaining()) {
			events.add(new SolrSystemEvent(day, SolrSystemEventType.RAIN)); 
		}
		
		if (optimalConditionsOfPreasureAndTemperature()) {
			events.add(new SolrSystemEvent(day, SolrSystemEventType.OPTIMAL_PREASSURE_AND_TEMPERATURE)); 
		}
		
		for (SolrSystemEvent event : events) {
			notifyObservers(event);
		}
	}
	
	private void notifyObservers(SolrSystemEvent event) {
		for (SolrSystemObserver observer : observers) {
			observer.notify(event);
		}
	}

	public boolean orbitsAreAlignedToTheSun() {
		return OrbitAlignmentQuery.orbitsAreAligned(orbits);
	}
	
	public boolean isRaining() {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();
		
		return PointIsInsideTrianglePredicate.evaluate(pointOfTheSun, p1, p2, p3);
	}

	public boolean optimalConditionsOfPreasureAndTemperature() {
		Iterator<Orbit> iterator = orbits.iterator();
		Point2D p1 = iterator.next().getCoordinates();
		Point2D p2 = iterator.next().getCoordinates();
		Point2D p3 = iterator.next().getCoordinates();
		
		return !orbitsAreAlignedToTheSun() && PointsHasSameSlopePredicate.evaluate(p1, p2, p3);
	}

	public void registerObserver(SolrSystemObserver observer) {
		observers.add(observer);
	}
}
