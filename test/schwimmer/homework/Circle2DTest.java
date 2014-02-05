package schwimmer.homework;

import org.junit.Assert;
import org.junit.Test;

public class Circle2DTest {

	@Test
	public void testGetArea() {
		final Circle2D circle = new Circle2D(5, 5, 10);
		final double area = circle.getArea();
		Assert.assertEquals(314.159265359, area, 0.1);
	}

	@Test
	public void testGetPerimeter() {
		final Circle2D circle = new Circle2D(5, 5, 10);
		final double perimeter = circle.getPerimeter();
		Assert.assertEquals(62.8318530718, perimeter, 0.1);
	}

	@Test
	public void testNoArgsConstructor() {
		final Circle2D circle = new Circle2D();
		Assert.assertEquals(0, circle.getX(), 0);
		Assert.assertEquals(0, circle.getY(), 0);
		Assert.assertEquals(1, circle.getRadius(), 0);
	}

	@Test
	public void testContainsPoint() {
		final Circle2D circle = new Circle2D(5, 5, 10);
		Assert.assertTrue(circle.contains(6, 6));
		Assert.assertFalse(circle.contains(100, 100));
	}

	@Test
	public void testContainsCircle() {
		final Circle2D a = new Circle2D(5, 5, 10);
		final Circle2D b = new Circle2D(6, 6, 1);
		final Circle2D c = new Circle2D(6, 6, 100);
		Assert.assertTrue(a.contains(b));
		Assert.assertFalse(a.contains(c));
	}

	@Test
	public void testOverlapsCircle() {
		final Circle2D a = new Circle2D(5, 5, 10);
		final Circle2D b = new Circle2D(6, 6, 1);
		final Circle2D c = new Circle2D(6, 6, 100);
		final Circle2D d = new Circle2D(100, 100, 1);
		Assert.assertTrue(a.overlaps(b));
		Assert.assertTrue(a.overlaps(c));
		Assert.assertFalse(a.overlaps(d));
	}

}
