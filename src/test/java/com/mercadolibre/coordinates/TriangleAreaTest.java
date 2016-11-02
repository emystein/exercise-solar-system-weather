package com.mercadolibre.coordinates;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import org.junit.Test;

public class TriangleAreaTest {

	@Test
	public void calculateAreaOfTriangleOfSide1() throws Exception {
		Point2D a = createPoint(0, 0);
		Point2D b = createPoint(1, 0);
		Point2D c = createPoint(1, 1);
		
		assertThat(TriangleArea.calculate(a, b, c), is(0.5));
	}

	private Double createPoint(double x, double y) {
		return new Point2D.Double(x, y);
	}
}
