package com.mercadolibre.galaxy.weather.analysis;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.mercadolibre.galaxy.Orbit;
import com.mercadolibre.galaxy.SolarSystemTestSupport;
import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public class IsDroughtAnalysisTest extends SolarSystemTestSupport {

	private SolarSystemAnalysis analysis;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		analysis = new IsDroughtAnalysis();
	}

	@Test
	public void positionsIn0RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(0, 0, 0);
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);
		
		assertDrought(event, 1);
	}

	@Test
	public void positionsInPiDivided2RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(Math.PI / 2, Math.PI / 2, Math.PI / 2);
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertDrought(event, 1);
	}

	@Test
	public void positionsInEquivalent0RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI * 2, Math.PI * 2);
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertDrought(event, 1);
	}

	@Test
	public void positionsInEquivalentPiDivided2RadiansShouldBeAligned() throws Exception {
		orbits = createPositions(Math.PI / 2, Math.PI / 2, (3 * (Math.PI / 2)));
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertDrought(event, 1);
	}

	@Test
	public void positionsInAnglesEquivalentTo60ShouldBeAligned() throws Exception {
		double first = Math.toRadians(60);
		double second = Math.toRadians(60 + 180);
		double third = Math.toRadians(60 + 360);
		orbits = createPositions(first, second, third);
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertDrought(event, 1);
	}

	
	@Test
	public void onePositionDifferentThanTwoShouldNotBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI / 2, Math.PI / 2);

		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertThat(event.getDay(), is(1));
		assertThat(event.getType(), is(SolarSystemEventType.NO_EVENT));
	}

	@Test
	public void allPositionsInDifferentRadiansShouldNotBeAligned() throws Exception {
		orbits = createPositions(0, Math.PI / 2, Math.PI);
		
		SolarSystemEvent event = analysis.analyze(orbits, 1);

		assertThat(event.getDay(), is(1));
		assertThat(event.getType(), is(SolarSystemEventType.NO_EVENT));
	}

	private Collection<Orbit> createPositions(double... radians) {
		Collection<Orbit> orbits = new ArrayList<>();
		
		for (double radian : radians) {
			orbits.add(new Orbit(radian));
		}
		
		return orbits;
	}

	private void assertDrought(SolarSystemEvent event, int day) {
		assertThat(event.getDay(), is(day));
		assertThat(event.getType(), is(SolarSystemEventType.DROUGHT));
	}

}
