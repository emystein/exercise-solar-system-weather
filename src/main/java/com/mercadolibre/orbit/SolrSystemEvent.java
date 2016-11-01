package com.mercadolibre.orbit;

public class SolrSystemEvent {

	private int day;
	private SolrSystemEventType type;

	public SolrSystemEvent(int day, SolrSystemEventType type) {
		this.day = day;
		this.type = type;
	}
	
	public int getDay() {
		return day;
	}

	public SolrSystemEventType getType() {
		return type;
	}
	
}
