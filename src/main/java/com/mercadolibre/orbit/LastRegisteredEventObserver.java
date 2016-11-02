package com.mercadolibre.orbit;

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
