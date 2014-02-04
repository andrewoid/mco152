package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(1025);

		// tell server to listen for connection
		// this is blocking, program waiting here to accept
		Socket socket = server.accept();// returns connection between client and
		// server

		OutputStream out = socket.getOutputStream();
		out.write("CONNECTED TO SERVER\n".getBytes());
		out.flush();

		InputStream in = socket.getInputStream();
		Scanner inputStreamReader = new Scanner(in);
		Scanner keyboard = new Scanner(System.in);
		String str;
		while (true) {
			str = inputStreamReader.nextLine();
			System.out.println(str);

			str = keyboard.nextLine() + "\n";
			out.write(str.getBytes());
			out.flush();
		}
		// server.close();

	}
}