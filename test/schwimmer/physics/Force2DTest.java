package schwimmer.physics;

import org.junit.Assert;
import org.junit.Test;

public class Force2DTest {

	@Test
	public void testAngleAndMagnitude() {
		final Force2D force = new Force2D(-3, 5);

		Assert.assertEquals(120.96, force.getAngle(), 0.01);
		Assert.assertEquals(5.831, force.getMagnitude(), 0.01);
	}

	@Test
	public void testAdd() {
		final Force2D a = new Force2D(8, 13);
		final Force2D b = new Force2D(26, 7);

		final Force2D c = a.plus(b);

		// Make sure A and B are not changed
		Assert.assertEquals(8, a.getX(), 0);
		Assert.assertEquals(13, a.getY(), 0);
		Assert.assertEquals(26, b.getX(), 0);
		Assert.assertEquals(7, b.getY(), 0);

		Assert.assertEquals(34, c.getX(), 0.0001);
		Assert.assertEquals(20, c.getY(), 0.0001);

		Assert.assertEquals(30.465, c.getAngle(), 0.01);
		Assert.assertEquals(39.446, c.getMagnitude(), 0.01);
	}

}
