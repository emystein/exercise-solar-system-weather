package com.mercadolibre.galaxy.event;

// TODO: remove together with Observer
public class NullSolarSystemEvent extends SolarSystemEvent {

	public NullSolarSystemEvent(int day) {
		super(day, SolarSystemEventType.NO_EVENT, 0);
	}

}
