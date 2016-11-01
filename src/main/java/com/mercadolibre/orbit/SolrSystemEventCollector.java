package com.mercadolibre.orbit;

import java.util.ArrayList;
import java.util.List;

public class SolrSystemEventCollector implements SolrSystemObserver {

	private List<SolrSystemEvent> events = new ArrayList<>();

	@Override
	public void notify(SolrSystemEvent event) {
		events.add(event);
	}

	public List<SolrSystemEvent> getEvents() {
		return events;
	}

}
