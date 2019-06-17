package fmt;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFormat {

	public static void main(String[] args) {
		float[] data = new float[1001];
		PrintWriter fw = null;
		try {
			fw = new PrintWriter(new FileWriter("data.dat"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}

		for (int i = 0; i < data.length; i++) {
			data[i] = (float) (Math.random() * 2000) - 1000;
		}

		int i = 0;
		while (i < data.length) {
			fw.printf("%8.2f", data[i++]);
			if (i >= data.length)
				break;
			fw.printf("  %8.2f", data[i++]);
			if (i >= data.length)
				break;
			fw.printf("  %8.2f", data[i++]);
			if (i >= data.length)
				break;
			fw.printf("  %8.2f\n", data[i++]);
			if (i >= data.length)
				break;
		}
		
		/*
		for(int j = 0; j < data.length; j += 4) {
			int remaining = data.length - j;
			int endIndex = j + ((remaining < 4) ? remaining : 4);
			for(int k = j; k < endIndex ; k++) {
				fw.printf("%8.2f", data[k]);
				System.out.printf("%8.2f", data[k]);
			}
			fw.printf("\n");
			System.out.printf("\n");
			
		}
		*/
		fw.close();
	}

}
// -1000.00 1.84 -397.34 -1000.00
// 95.86 603.54 144.78 -0.12
//
// Send the output to a file called data.dat
