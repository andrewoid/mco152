package schwimmer.net;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.JTextArea;

public class ReaderThread extends Thread {

	private Socket socket;
	private JTextArea area;

	public ReaderThread(Socket socket, JTextArea area) {
		super();
		this.socket = socket;
		this.area = area;
	}

	public void run() {

		Scanner scanner;
		try {
			scanner = new Scanner(socket.getInputStream());

			while (true) {
				String line = scanner.nextLine();
				area.append(line);
				area.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {

		}

	}

}
