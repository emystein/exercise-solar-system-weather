package com.mercadolibre.galaxy.event.observer;

import org.springframework.stereotype.Component;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;

@Component
public class LastRegisteredEventObserver implements SolarSystemObserver {

	private SolarSystemEvent lastRegisteredEvent;

	@Override
	public void notify(SolarSystemEvent event) {
		this.lastRegisteredEvent = event;
	}

	public SolarSystemEvent getLastRegisteredEvent() {
		return this.lastRegisteredEvent;
	}

}
