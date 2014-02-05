package schwimmer.homework;

public class Circle2D {

	private final double	x;
	private final double	y;
	private final double	radius;

	public Circle2D() {
		this(0, 0, 1);
	}

	public Circle2D(final double x, final double y, final double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	private double distance(final double x, final double y) {
		return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
	}

	public boolean contains(final double x, final double y) {
		return distance(x, y) <= radius;
	}

	public boolean contains(final Circle2D circle) {
		return distance(circle.x, circle.y) + circle.radius <= this.radius;
	}

	public boolean overlaps(final Circle2D circle) {
		return distance(circle.x, circle.y) <= circle.radius + this.radius;
	}

}
