package iostuff;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SimpleFile {

	public static void main(String[] args) {
		// oneApproach();
		// tryingWithResources();
		usingAScanner();
	}

	public static void oneApproach() {
		boolean success = false;
		BufferedReader input = null;
		BufferedReader br = null;
		String filename = null;

		input = new BufferedReader(new InputStreamReader(System.in));
		while (!success) {
			System.out.print("Please enter a filename: ");
			System.out.flush();
			try {
				filename = input.readLine();
			} catch (IOException ioe) {
				System.out.println("Hmm, I'm having trouble reading your input.");
			}

			try {
				Path f = Paths.get(filename);
				if (Files.exists(f)) {
					System.out.println("File " + filename + " exists");

					Path absPath = f.toAbsolutePath();
					System.out.println("  parent directory is " + absPath.getParent());

					System.out.println("  " + (Files.isReadable(f) ? "is" : "is not") + " readable");
					System.out.println("  " + (Files.isWritable(f) ? "is" : "is not") + " writeable");
					System.out.println("  and contains " + Files.size(f) + " bytes");
					List<String> lines = Files.readAllLines(f, Charset.defaultCharset());
					for (String line : lines) {
						System.out.println("> " + line);
					}

					// Or
					Files.lines(f).forEach(line -> System.out.println("> " + line));
					success = true;
				} else {
					System.out.println("File " + filename + " does not exist");
				}
			} catch (FileNotFoundException fnfe) {
				System.out.println("Failed to open file: " + filename);
			} catch (IOException ioe) {
				System.out.println("Trouble reading the file");
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException ioe) {
						System.out.println("Trouble closing the file");
					}
				}
			}
		}

	}

	public static void tryingWithResources() {
		boolean success = false;
		BufferedReader br = null;
		String filename = null;

		try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
			while (!success) {
				System.out.print("Please enter a filename: ");
				System.out.flush();
				filename = input.readLine();

				Path f = Paths.get(filename);
				if (Files.exists(f)) {
					System.out.println("File " + filename + " exists");

					Path absPath = f.toAbsolutePath();
					System.out.println("  parent directory is " + f.getParent());

					System.out.println("  " + (Files.isReadable(f) ? "is" : "is not") + " readable");
					System.out.println("  " + (Files.isWritable(f) ? "is" : "is not") + " writeable");
					System.out.println("  and contains " + Files.size(f) + " bytes");

					List<String> lines = Files.readAllLines(f, Charset.defaultCharset());
					for (String line : lines) {
						System.out.println("> " + line);
					}
					success = true;
				} else {
					System.out.println("File " + filename + " does not exist");
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Failed to open file: " + filename);
		} catch (IOException ioe) {
			System.out.println("Trouble reading the file");
		}

	}

	public static void usingAScanner() {
		boolean success = false;
		BufferedReader br = null;
		String filename = null;

		try (Scanner input = new Scanner(System.in)) {
			while (!success) {
				System.out.print("Please enter a filename: ");
				System.out.flush();
				filename = input.nextLine();

				Path f = Paths.get(filename);
				System.out.println("Path is " + f);
				if (Files.exists(f)) {
					System.out.println("File " + filename + " exists");

					Path absPath = f.toAbsolutePath();
					System.out.println("  parent directory is " + absPath.getParent());

					System.out.println("  " + (Files.isReadable(f) ? "is" : "is not") + " readable");
					System.out.println("  " + (Files.isWritable(f) ? "is" : "is not") + " writeable");
					System.out.println("  and contains " + Files.size(f) + " bytes");

					List<String> lines = Files.readAllLines(f, Charset.defaultCharset());
					for (String line : lines) {
						System.out.println("> " + line);
					}
					success = true;
				} else {
					System.out.println("File " + filename + " does not exist");
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("Failed to open file: " + filename);
		} catch (IOException ioe) {
			System.out.println("Trouble reading the file");
		}

	}

}
