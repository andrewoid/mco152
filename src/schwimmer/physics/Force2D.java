package schwimmer.physics;

public class Force2D {

	private final double	x;
	private final double	y;

	public Force2D(final double x, final double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getAngle() {
		return Math.toDegrees(Math.atan2(y, x));
	}

	public double getMagnitude() {
		return Math.sqrt(x * x + y * y);
	}

	public Force2D plus(final Force2D other) {
		final double x = this.getX() + other.getX();
		final double y = this.getY() + other.getY();

		return new Force2D(x, y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}
