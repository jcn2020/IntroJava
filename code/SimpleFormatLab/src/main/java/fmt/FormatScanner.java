package fmt;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
 * CsvScanner is a basic example illustrating how to use
 * the Scanner API introduced in Java 1.5.
 * <p/>
 * The CsvScanner reads lines in a text file which
 * uses a comma as a delimiter.
 * <p/>
 * <p/>
 * User: developintelligence llc
 * Date: Mar 6, 2010
 * Time: 1:17:20 PM
 */
public class FormatScanner {

    public static void main(String[] args) {
        if (args.length == 0) {
            //System.out.println("CsvScanner needs a csv file name as a argument.");
            //System.exit(0);
        	args = new String [] {"data.dat" };
        }

        try {
            Scanner fileScanner = new Scanner(new File(args[0]));
            String curSymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
            NumberFormat nFormat = NumberFormat.getCurrencyInstance();
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine().trim();
                String [] vals = line.split("\\s\\s*");
                float [] floats = new float[vals.length];
                float lineSum = 0;
                for(int i = 0; i < vals.length; i++) {
                	floats[i] = Float.parseFloat(vals[i]);
                	String sf = nFormat.format(floats[i]);
                	lineSum += floats[i];
                	//System.out.printf("%s%(,12.2f", curSymbol, floats[i]);
                	System.out.printf("%-12s", sf);
                }
               	System.out.printf("%-12s\n", nFormat.format(lineSum));
            }
            System.out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
