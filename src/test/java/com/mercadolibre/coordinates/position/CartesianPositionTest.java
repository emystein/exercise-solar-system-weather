package com.mercadolibre.coordinates.position;

import java.awt.geom.Point2D;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class CartesianPositionTest {

	@Test
	public void positionWith0RadiansShouldHave0XAnd0Y() throws Exception {
		double radius = 1000;
		
		Position position = new Position(radius, 0);
		
		Point2D expectedPoint = new Point2D.Double(radius, 0);
		
		Assert.assertThat(position.getCoordinates(), Matchers.is(expectedPoint));
	}
}
