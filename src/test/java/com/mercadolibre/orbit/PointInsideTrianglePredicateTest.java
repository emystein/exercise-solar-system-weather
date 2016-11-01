package com.mercadolibre.orbit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;

import org.junit.Test;

public class PointInsideTrianglePredicateTest {
	Point2D zero = new Point2D.Double(0, 0);

	@Test
	public void originInsideQuadrantOneTwoAndThreeTriangle() throws Exception {
		Point2D p1 = new Point2D.Double(3, 1); 
		Point2D p2 = new Point2D.Double(-4, 2); 
		Point2D p3 = new Point2D.Double(-4, -5);
		
		assertTrue(PointInsideTrianglePredicate.evaluate(zero, p1, p2, p3));
	}

	@Test
	public void originNotInsideHigherYTriangle() throws Exception {
		Point2D p1 = new Point2D.Double(2, 2); 
		Point2D p2 = new Point2D.Double(0, 4); 
		Point2D p3 = new Point2D.Double(-3, 3);
		
		assertFalse(PointInsideTrianglePredicate.evaluate(zero, p1, p2, p3));
	}

}
