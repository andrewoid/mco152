package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Jabber {

	public static void main(String[] args) throws UnknownHostException,
			IOException, InterruptedException {
		Socket socket = new Socket("localhost", 8080);
		OutputStream output = socket.getOutputStream();

		for (int i = 0; i < 1000; i++) {
			output.write(("LINE #" + i + "\n").getBytes());
			output.flush();
			Thread.sleep(1000);
		}
	}

}
