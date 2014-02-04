package schwimmer.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatServer {

	public final static Logger log = Logger.getLogger(ChatServer.class
			.getName());

	public static void main(String args[]) throws IOException {

		ServerSocket server = new ServerSocket(8080);

		Socket socket;
		while ((socket = server.accept()) != null) {
			log.log(Level.INFO, "Socket Accepted");
			new ClientHandlerThread(socket).start();
		}

	}
}
