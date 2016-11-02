package com.mercadolibre.orbit;

public class SolarSystemEvent {

	private int day;
	private SolarSystemEventType type;

	public SolarSystemEvent(int day, SolarSystemEventType type) {
		this.day = day;
		this.type = type;
	}
	
	public int getDay() {
		return day;
	}

	public SolarSystemEventType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "SolrSystemEvent [day=" + day + ", type=" + type + "]";
	}
	
}
