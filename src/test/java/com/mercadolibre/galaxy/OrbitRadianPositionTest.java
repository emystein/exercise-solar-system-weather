package com.mercadolibre.galaxy;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.mercadolibre.galaxy.Orbit;

public class OrbitRadianPositionTest {
	double revolution = Math.PI * 2;

	@Test
	public void createPositiveRadianPosition() throws Exception {
		Orbit position = new Orbit(1);
		
		assertThat(position.getRadians(), is(1d));
	}

	@Test
	public void createNegativeRadianPosition() throws Exception {
		Orbit position = new Orbit(-1);
		
		assertThat(position.getRadians(), is(revolution-1d));
	}

	@Test
	public void roundPositive2PiRadiansTo0() throws Exception {
		Orbit position = new Orbit(revolution);
		
		assertThat(position.getRadians(), is(0d));
	}

	@Test
	public void roundPositiveBiggerThan2PiRadians() throws Exception {
		Orbit position = new Orbit(revolution + 1);
		
		assertThat(position.getRadians(), is(1d));
	}

	@Test
	public void roundNegative2PiRadiansTo0() throws Exception {
		Orbit position = new Orbit(-revolution);
		
		assertThat(position.getRadians(), is(0d));
	}

	@Test
	public void roundNegativeBiggerThan2PiRadians() throws Exception {
		Orbit position = new Orbit(-revolution - 1);
		
		assertThat(position.getRadians(), Matchers.is(-1d));
	}
}
