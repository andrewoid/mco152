package schwimmer.physics;

import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.translate(0, getHeight());

		Projectile p = new Projectile(37, 73);
		for (int i = 0; i < 10; i++) {

			g.drawOval((int) p.getX(i), (int) -p.getY(i), 10, 10);

		}
	}

}
