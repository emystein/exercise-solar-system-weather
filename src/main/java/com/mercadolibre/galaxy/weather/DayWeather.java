package com.mercadolibre.galaxy.weather;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class DayWeather {

	@Id
	@JsonProperty("dia")
	private int day;
	@JsonProperty("clima")
	private Weather weather;
	@JsonIgnore // in order to avoid showing in the HTTP response
	private double value;

	public DayWeather(int day, Weather weather, double value) {
		this.day = day;
		this.weather = weather;
		this.value = value;
	}
	
	public DayWeather(int day, Weather weather) {
		this(day, weather, 0);
	}

	// only needed by JPA
	public DayWeather() {
		this(0, Weather.None, 0);
	}

	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DayWeather [day=");
		builder.append(day);
		builder.append(", weather=");
		builder.append(weather);
		builder.append("]");
		return builder.toString();
	}

}
