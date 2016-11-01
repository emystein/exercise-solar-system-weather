package com.mercadolibre.geometry;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;

import org.junit.Test;

import com.mercadolibre.geometry.PointInsideTrianglePredicate;

public class PointInsideTrianglePredicateTest {
	Point2D zero = createPoint(0, 0);

	@Test
	public void originInsideQuadrantOneTwoAndThreeTriangle() throws Exception {
		Point2D p1 = createPoint(3, 1); 
		Point2D p2 = createPoint(-4, 2); 
		Point2D p3 = createPoint(-4, -5);
		
		assertTrue(PointInsideTrianglePredicate.evaluate(zero, p1, p2, p3));
	}

	@Test
	public void originNotInsideHigherYTriangle() throws Exception {
		Point2D p1 = createPoint(2, 2); 
		Point2D p2 = createPoint(0, 4); 
		Point2D p3 = createPoint(-3, 3);
		
		assertFalse(PointInsideTrianglePredicate.evaluate(zero, p1, p2, p3));
	}

	private Point2D createPoint(int x, int y) {
		return new Point2D.Double(x, y);
	}

	@Test
	public void noTriangleFormed() throws Exception {
		Point2D p1 = createPoint(500, 0); 
		Point2D p2 = createPoint(1000, 0); 
		Point2D p3 = createPoint(2000, 0);
		
		assertFalse(PointInsideTrianglePredicate.evaluate(zero, p1, p2, p3));
	}

}
