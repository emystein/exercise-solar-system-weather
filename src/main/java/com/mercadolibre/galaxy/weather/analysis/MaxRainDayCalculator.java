package com.mercadolibre.galaxy.weather.analysis;

import java.util.List;

import com.mercadolibre.galaxy.event.SolarSystemEvent;

public class MaxRainDayCalculator {

	public int calculate(List<SolarSystemEvent> rainEvents) {
		double maxRain = 0;
		int maxRainDay = 0;

		for (SolarSystemEvent event : rainEvents) {
			if (event.getValue() > maxRain) {
				maxRain = event.getValue();
				maxRainDay = event.getDay();
			}
		}

		return maxRainDay;
	}

}
