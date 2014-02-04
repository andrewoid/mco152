package schwimmer.net;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatFrame extends JFrame {

	private JPanel pane;
	private JTextArea area;
	private JTextField input;
	private JButton button;
	private Socket socket;

	public ChatFrame(Socket socket) {
		this.socket = socket;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 400);
		setTitle("Chat");

		pane = new JPanel();
		pane.setLayout(new BorderLayout());
		area = new JTextArea();
		area.setEditable(false);
		JPanel lowerPane = new JPanel();
		lowerPane.setLayout(new BorderLayout());
		input = new JTextField();
		button = new JButton("Send");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				sendText();
			}
		});

		lowerPane.add(input, BorderLayout.CENTER);
		lowerPane.add(button, BorderLayout.EAST);

		pane.add(area, BorderLayout.CENTER);
		pane.add(lowerPane, BorderLayout.SOUTH);

		setContentPane(pane);
	}

	protected void sendText() {
		String text = input.getText();
		area.append(text);
		area.append("\n");
		input.setText("");
		OutputStream out;
		try {
			out = socket.getOutputStream();
			out.write(text.getBytes());
			out.write("\n".getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		// ServerSocket server = new ServerSocket(1025);
		// Socket s = server.accept();

		Socket s = new Socket("192.168.117.119", 1025);

		ChatFrame chatFrame = new ChatFrame(s);
		chatFrame.setVisible(true);
		ReaderThread readerThread = new ReaderThread(s, chatFrame.area);
		readerThread.start();
	}
}
