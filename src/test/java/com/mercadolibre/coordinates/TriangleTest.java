package com.mercadolibre.coordinates;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import org.junit.Test;

public class TriangleTest {
	private Point2D zero = createPoint(0, 0);
	
	@Test
	public void calculatePerimeterOfTriangleOfSide1() throws Exception {
		Point2D a = createPoint(0, 0);
		Point2D b = createPoint(1, 0);
		Point2D c = createPoint(1, 1);
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertThat(triangle.getPerimeter(), is(closeTo(3.41, 0.01)));
	}

	@Test
	public void calculateAreaOfTriangleOfSide1() throws Exception {
		Point2D a = createPoint(0, 0);
		Point2D b = createPoint(1, 0);
		Point2D c = createPoint(1, 1);
		
		Triangle triangle = new Triangle(a, b, c);
		
		assertThat(triangle.getArea(), is(closeTo(0.5, 0.001)));
	}

	@Test
	public void originInsideQuadrantOneTwoAndThreeTriangle() throws Exception {
		Point2D p1 = createPoint(3, 1); 
		Point2D p2 = createPoint(-4, 2); 
		Point2D p3 = createPoint(-4, -5);
		
		Triangle triangle = new Triangle(p1, p2, p3);
		
		assertTrue(triangle.containsPoint(zero));
	}

	@Test
	public void originNotInsideHigherYTriangle() throws Exception {
		Point2D p1 = createPoint(2, 2); 
		Point2D p2 = createPoint(0, 4); 
		Point2D p3 = createPoint(-3, 3);

		Triangle triangle = new Triangle(p1, p2, p3);
		
		assertFalse(triangle.containsPoint(zero));
	}

	private Point2D createPoint(int x, int y) {
		return new Point2D.Double(x, y);
	}

	@Test
	public void noTriangleFormedDoesntContainPoint() throws Exception {
		Point2D p1 = createPoint(500, 0); 
		Point2D p2 = createPoint(1000, 0); 
		Point2D p3 = createPoint(2000, 0);
		
		Triangle triangle = new Triangle(p1, p2, p3);
		
		assertFalse(triangle.containsPoint(zero));
	}

	private Double createPoint(double x, double y) {
		return new Point2D.Double(x, y);
	}
}
