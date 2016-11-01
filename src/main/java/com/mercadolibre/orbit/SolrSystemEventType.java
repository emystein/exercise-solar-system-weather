package com.mercadolibre.orbit;

public enum SolrSystemEventType {
	DROUGHT("Sequía"), RAIN("Lluvia"), OPTIMAL_PREASSURE_AND_TEMPERATURE("Optimas Temp. y Pres.");
	
	private String value;
	
	private SolrSystemEventType(String value) {
		this.value = value;
	}
	
	public String toString() {
		return this.value;
	}
}
