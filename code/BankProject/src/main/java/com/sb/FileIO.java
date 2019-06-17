package com.sb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {

	public static void main(String[] args) {
		FileIO fileIO = new FileIO();

		fileIO.printFileWithTWR("src/com/sb/BankException.java");
	}

	public void printFileWithTWR(String fileName) {

		try (FileReader reader = new FileReader(fileName);
				BufferedReader br = new BufferedReader(reader);
				MyClass mc = new MyClass()) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("line is " + line);
			}

			MyClass.doStuff(5);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void printFile(String fileName) {

		BufferedReader br = null;
		try {
			FileReader reader = new FileReader(fileName);
			br = new BufferedReader(reader);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("line is " + line);
			}
			;

			MyClass.doStuff(5);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class MyClass implements AutoCloseable {
	public static void doStuff(int i) {
		if (i < 10) {
			throw new RuntimeException("i is less than 10");
		}
		// Other important work
	}

	@Override
	public void close() {
		System.out.println("MyClass.close called");

	}
}