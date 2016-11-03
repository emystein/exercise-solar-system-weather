package com.mercadolibre.galaxy.weather;

public enum Weather {
	Drought("Sequía"), Rain("Lluvia"), OptimalPreasureAndTemperature("Óptimas presión y temp."), None("No se registra");
	
	private String value;
	
	private Weather(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
