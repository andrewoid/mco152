package schwimmer.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class Downloader {

	public static void main(String[] args) throws UnknownHostException,
			IOException {

		Socket socket = new Socket("www.amazon.com", 80);
		OutputStream out = socket.getOutputStream();
		out.write("GET /index.html\n\n".getBytes());
		out.flush();

		InputStream in = socket.getInputStream();
		String s = IOUtils.toString(in);
		System.out.println(s);

		socket.close();

	}

}
