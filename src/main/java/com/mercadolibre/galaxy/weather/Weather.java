package com.mercadolibre.galaxy.weather;

public enum Weather {
	DROUGHT("Sequía"), RAIN("Lluvia"), OPTIMAL_PREASSURE_AND_TEMPERATURE("Óptimas presión y temp."), NONE("No se registra");
	
	private String value;
	
	private Weather(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
