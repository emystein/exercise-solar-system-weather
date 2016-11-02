package com.mercadolibre.orbit.analysis;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.mercadolibre.orbit.SolarSystemEvent;
import com.mercadolibre.orbit.SolarSystemEventType;

public class MaxRainDayCalculatorTest {

	@Test
	public void calculate() throws Exception {
		List<SolarSystemEvent> list= new ArrayList<>();
		list.add(new SolarSystemEvent(1, SolarSystemEventType.RAIN, 1));
		list.add(new SolarSystemEvent(2, SolarSystemEventType.RAIN, 5));
		list.add(new SolarSystemEvent(3, SolarSystemEventType.RAIN, 1));

		MaxRainDayCalculator calculator = new MaxRainDayCalculator();
		
		double maxRainDay = calculator.calculate(list);

		assertThat(maxRainDay, is(2d));
	}
}
