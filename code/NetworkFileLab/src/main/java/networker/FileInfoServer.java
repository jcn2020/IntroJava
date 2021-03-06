package networker;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileInfoServer {

	public static void main(String[] args) {
		FileInfoServer fis = new FileInfoServer();
		fis.go();
	}

	public void go() {
		int num = Runtime.getRuntime().availableProcessors();
		ExecutorService es = Executors.newFixedThreadPool(num);

		try (ServerSocket ss = new ServerSocket(1234);) {
			System.out.println("Started the File Info server");
			for (;;) {
				try {
					Socket s = ss.accept();
					System.out.println("Got a conection!");
					RequestHandler rs = new RequestHandler(s);
					//rs.run();
					es.execute(rs);
					// processRequest(s);
				} catch (IOException ioe) {
					System.err.println("Network problem:");
					ioe.printStackTrace(System.err);
				}
			}
		} catch (IOException e) {
			System.err.println("Failed to create server socket");
			System.exit(1);
		}
	}

	class RequestHandler implements Runnable {

		private Socket socket;

		public RequestHandler(Socket s) {
			this.socket = s;
		}

		public void run() {
			// Read FileName from Input Stream
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = reader.readLine();
				File file = new File(line);
				StringBuffer response = new StringBuffer();
				if (file.exists()) {
					response.append(
							file.getAbsolutePath()).append(": size = ")
							.append(file.length())
							.append( ", readable:")
							.append(file.canRead());
				} else {
					response.append("File " + line + " does not Exist");
				}

				// Send the response
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

				pw.println(response.toString());
				pw.flush();
				pw.close();
				socket.close();
			} catch (IOException e) {

			}
		}
	}

}
