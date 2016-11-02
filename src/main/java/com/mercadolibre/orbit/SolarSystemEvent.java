package com.mercadolibre.orbit;

public class SolarSystemEvent {

	private int day;
	private SolarSystemEventType type;
	private double value;

	public SolarSystemEvent(int day, SolarSystemEventType type, double value) {
		this.day = day;
		this.type = type;
		this.value = value;
	}
	
	public int getDay() {
		return day;
	}

	public SolarSystemEventType getType() {
		return type;
	}

	public double getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "SolarSystemEvent [day=" + day + ", type=" + type + ", value=" + value + "]";
	}
	
}
