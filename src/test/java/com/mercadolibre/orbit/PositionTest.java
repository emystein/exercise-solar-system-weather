package com.mercadolibre.orbit;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

public class PositionTest {
	double revolution = Math.PI * 2;

	@Test
	public void createPositiveRadianPosition() throws Exception {
		Position position = new Position(1);
		
		assertThat(position.getRadians(), is(1d));
	}

	@Test
	public void createNegativeRadianPosition() throws Exception {
		Position position = new Position(-1);
		
		assertThat(position.getRadians(), is(revolution-1d));
	}

	@Test
	public void roundPositive2PiRadiansTo0() throws Exception {
		Position position = new Position(revolution);
		
		assertThat(position.getRadians(), is(0d));
	}

	@Test
	public void roundPositiveBiggerThan2PiRadians() throws Exception {
		Position position = new Position(revolution + 1);
		
		assertThat(position.getRadians(), is(1d));
	}

	@Test
	public void roundNegative2PiRadiansTo0() throws Exception {
		Position position = new Position(-revolution);
		
		assertThat(position.getRadians(), is(0d));
	}

	@Test
	public void roundNegativeBiggerThan2PiRadians() throws Exception {
		Position position = new Position(-revolution - 1);
		
		assertThat(position.getRadians(), Matchers.is(-1d));
	}
}
