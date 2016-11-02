package com.mercadolibre.galaxy.event;

public enum SolarSystemEventType {
	DROUGHT("Sequía"), RAIN("Lluvia"), OPTIMAL_PREASSURE_AND_TEMPERATURE("Óptimas presión y temp."), NO_EVENT("No hay evento");
	
	private String value;
	
	private SolarSystemEventType(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
