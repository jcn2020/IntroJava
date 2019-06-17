package networker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class FileInfoClient {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			BufferedReader stdin = new BufferedReader(new InputStreamReader(
					System.in));
			String line = null;
			while (true) {
				System.out.print("Enter File Name: ");
				line = stdin.readLine();
				if ("quit".equals(line)) {
					break;
				}
				processRequest(line);
			}
		} catch (IOException ex) {
			System.err.println("Problem with the network");
			ex.printStackTrace(System.err);
			System.exit(1);
		}

	}

	public static void processRequest(String fileName) throws UnknownHostException,
			IOException {
		Socket s = new Socket("localhost", 1234);

		PrintWriter pw = new PrintWriter(new OutputStreamWriter(
				s.getOutputStream()));

		pw.println(fileName);
		pw.flush();

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				s.getInputStream()));
		System.out.println("Server says:");
		String st = null;
		while ((st = reader.readLine()) != null) {
			System.out.println(st);
		}
		reader.close();
		s.close();

	}
}
