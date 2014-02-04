package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Echo {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 8080);

		InputStream in = socket.getInputStream();
		Scanner scanner = new Scanner(in);

		System.out.println(scanner.nextLine());

	}

}
