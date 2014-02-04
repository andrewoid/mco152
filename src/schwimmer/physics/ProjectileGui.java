package schwimmer.physics;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ProjectileGui extends JFrame {

	public ProjectileGui() {
		setSize(800, 600);
		setTitle("Projectile GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(new GraphComponent(), BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String args[]) {

		new ProjectileGui();

	}

}
