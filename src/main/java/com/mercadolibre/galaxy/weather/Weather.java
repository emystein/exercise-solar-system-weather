package com.mercadolibre.galaxy.weather;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Weather {
	Drought("Sequía"), Rain("Lluvia"), OptimalPreasureAndTemperature("Óptimas presión y temp."), None("No se registra");

	private String value;

	private Weather(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public String toString() {
		return value;
	}
}
