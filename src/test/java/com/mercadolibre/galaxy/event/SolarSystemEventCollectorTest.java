package com.mercadolibre.galaxy.event;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SolarSystemEventCollectorTest {

	private SolarSystemEventCollector collector;
	
	@Before
	public void setUp() throws Exception {
		collector = new SolarSystemEventCollector();
	}
	
	@Test
	public void collectOneEvent() throws Exception {
		assertThat(collector.getEvents(), is(empty()));

		SolarSystemEvent event = new SolarSystemEvent(1, SolarSystemEventType.DROUGHT, 0);
		collector.notify(event);
		
		assertThat(collector.getEvents(), is(not(empty())));
		assertThat(collector.getEvents().get(0), is(event));
	}

	@Test
	public void collectTwoEvents() throws Exception {
		assertThat(collector.getEvents(), is(empty()));
		
		SolarSystemEvent event1 = new SolarSystemEvent(1, SolarSystemEventType.DROUGHT, 0);
		collector.notify(event1);
		SolarSystemEvent event2 = new SolarSystemEvent(2, SolarSystemEventType.DROUGHT, 0);
		collector.notify(event2);
		
		assertThat(collector.getEvents().size(), is(2));
		assertThat(collector.getEvents().get(0), is(event1));
		assertThat(collector.getEvents().get(1), is(event2));
	}
	
	@Test
	public void filterOutNullEvents() throws Exception {
		assertThat(collector.getEvents(), is(empty()));
		
		SolarSystemEvent event = new SolarSystemEvent(1, SolarSystemEventType.DROUGHT, 0);
		collector.notify(event);

		collector.notify(new NullSolarSystemEvent(1));
		
		assertThat(collector.getEvents().size(), is(1));
		assertThat(collector.getEvents().get(0), is(event));
	}

	@Test
	public void filterOutNullEventsWhenOnlyNullEvents() throws Exception {
		assertThat(collector.getEvents(), is(empty()));
		
		collector.notify(new NullSolarSystemEvent(1));

		assertThat(collector.getEvents(), is(empty()));
	}
}
