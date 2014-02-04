package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandlerThread extends Thread {

	private Socket socket;

	public ClientHandlerThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		InputStream in;
		try {
			in = socket.getInputStream();

			Scanner scanner = new Scanner(in);

			String line;
			while ((line = scanner.nextLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
