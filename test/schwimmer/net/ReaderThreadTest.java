package schwimmer.net;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextArea;

import org.junit.Test;
import org.mockito.Mockito;

public class ReaderThreadTest {

	@Test
	public void testReadAndAppend() throws IOException {

		Socket socket = Mockito.mock(Socket.class);
		JTextArea area = Mockito.mock(JTextArea.class);

		ByteArrayInputStream in = new ByteArrayInputStream(
				"JOIN andrew\nJOIN stein\nJOIN gurwitz\nJOIN spiegel\nJOIN karman\n"
						.getBytes());

		Mockito.when(socket.getInputStream()).thenReturn(in);

		ReaderThread thread = new ReaderThread(socket, area);

		thread.run();

		Mockito.verify(area, times(10)).append(Mockito.anyString());

	}

}
