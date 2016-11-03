package com.mercadolibre.galaxy.weather.report;

import java.util.List;

import com.mercadolibre.galaxy.event.SolarSystemEvent;
import com.mercadolibre.galaxy.event.SolarSystemEventType;

public class WeatherReportResult {

	private long numberOfDays;
	private List<SolarSystemEvent> events;
	private long maxRainDay;
	private long droughtCount;
	private long rainCount;
	private long optimalPreasureAndTemperatureCount;
	
	public WeatherReportResult(long numberOfDays, List<SolarSystemEvent> events, long maxRainDay) {
		this.numberOfDays = numberOfDays;
		this.events = events;
		this.maxRainDay = maxRainDay;
		this.droughtCount = countEventsByType(events, SolarSystemEventType.DROUGHT);
		this.rainCount = countEventsByType(events, SolarSystemEventType.RAIN);
		this.optimalPreasureAndTemperatureCount = countEventsByType(events, SolarSystemEventType.OPTIMAL_PREASSURE_AND_TEMPERATURE);
	}

	private long countEventsByType(List<SolarSystemEvent> events, SolarSystemEventType eventType) {
		return events.stream().filter(event -> event.getType().equals(eventType)).count();
	}

	public List<SolarSystemEvent> getEvents() {
		return events;
	}

	public long getDroughtCount() {
		return droughtCount;
	}

	public long getRainCount() {
		return rainCount;
	}

	public long getMaxRainDay() {
		return maxRainDay;
	}

	public long getOptimalPreasureAndTemperatureCount() {
		return optimalPreasureAndTemperatureCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n");
		builder.append("=====================").append("\n");
		builder.append("Galaxy Weather Report").append("\n");
		builder.append("=====================").append("\n");
		builder.append("Number of days: ").append(numberOfDays).append("\n");
		builder.append("Drought Count: ").append(droughtCount).append("\n");
		builder.append("Rain Count: ").append(rainCount).append("\n");
		builder.append("Day of maximum rain: ").append(maxRainDay).append("\n");
		builder.append("Optimal Preasure and Temperature Count: ").append(optimalPreasureAndTemperatureCount).append("\n");
		return builder.toString();
	}
	
	
}
