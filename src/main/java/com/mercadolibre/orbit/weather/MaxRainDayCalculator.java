package com.mercadolibre.orbit.weather;

import java.util.List;

import com.mercadolibre.orbit.SolarSystemEvent;

public class MaxRainDayCalculator {

	public double calculate(List<SolarSystemEvent> rainEvents) {
		double maxRain = 0;
		double maxRainDay = 0;

		for (SolarSystemEvent event : rainEvents) {
			if (event.getValue() > maxRain) {
				maxRain = event.getValue();
				maxRainDay = event.getDay();
			}
		}

		return maxRainDay;
	}

}
