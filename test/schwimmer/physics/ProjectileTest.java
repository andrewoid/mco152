package schwimmer.physics;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class ProjectileTest {

	@Test
	public void testGetX() {
		Projectile p = new Projectile(37, 73);
		assertEquals( 291.5, p.getX(5),.1);
	}
	

	@Test
	public void testGetY() {
		Projectile p = new Projectile(37, 73);
		assertEquals( 97.1, p.getY(5),.1);
	}
	
}
