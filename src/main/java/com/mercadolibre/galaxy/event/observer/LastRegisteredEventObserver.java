package com.mercadolibre.galaxy.event.observer;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemObserver;

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
