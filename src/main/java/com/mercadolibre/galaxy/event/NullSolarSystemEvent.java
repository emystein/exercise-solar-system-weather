package com.mercadolibre.galaxy.event;

public class NullSolarSystemEvent extends SolarSystemEvent {

	public NullSolarSystemEvent(int day) {
		super(day, SolarSystemEventType.NO_EVENT, 0);
	}

}
