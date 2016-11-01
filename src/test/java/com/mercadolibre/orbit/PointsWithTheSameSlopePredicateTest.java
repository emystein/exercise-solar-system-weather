package com.mercadolibre.orbit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;

import org.junit.Test;

public class PointsWithTheSameSlopePredicateTest {
	private Point2D origin = createPoint(0, 0);

	@Test
	public void originAndX1Y1AndX2Y2ShouldHaveTheSamePendient() throws Exception {
		Point2D x1y1 = createPoint(1, 1);
		Point2D x2y2 = createPoint(2, 2);
		
		assertTrue(PointsWithTheSameSlopePredicate.evaluate(origin, x1y1, x2y2));
	}

	@Test
	public void originAndX1Y1AndX2Y1ShouldNotHaveTheSamePendient() throws Exception {
		Point2D x1y1 = createPoint(1, 1);
		Point2D x2y1 = createPoint(2, 1);
		
		assertFalse(PointsWithTheSameSlopePredicate.evaluate(origin, x1y1, x2y1));
	}

	
	private Point2D createPoint(int x, int y) {
		return new Point2D.Double(x, y);
	}
}
