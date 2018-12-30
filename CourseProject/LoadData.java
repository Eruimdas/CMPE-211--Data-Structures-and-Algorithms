import java.util.Scanner;
import java.util.regex.Pattern;

import edu.princeton.cs.algs4.In;

/*
 *  this class contains the methods that helps us to  
 * 	collect data from a file.
 * 
 */

public class LoadData {
	private double[] data; // we created an empty double array
							// we created it as an attribute because we want to make modifications on same
							// array

	public LoadData(String datapath) { // writes data to the empty array that we have just created
		String[] s = datapath.split(Pattern.quote("."));
		if (s[1].equals("txt")) {
			data = In.readDoubles(datapath); // reads the data with using edu.princeton.cs.algs4's In class
		} else if (s[1].equals("csv")) {
			Scanner std = new Scanner(System.in);
			String[] sx = In.readStrings(datapath);
			data = new double[sx.length];
			int x = sx[0].split(Pattern.quote(",")).length + 1;
			System.out.println("Please enter the column index you want to calculate the anomaly: " + "(value E [0,"
					+ (sx[0].split(Pattern.quote(",")).length - 1) + "])");
			while (x >= sx[0].split(Pattern.quote(",")).length || x < 0) {
				x = std.nextInt();
				if (x >= sx[0].split(Pattern.quote(",")).length || x < 0) {
					System.out
							.println("The value must be between 0 and " + sx[0].split(Pattern.quote(",")).length + ".");
				}
			}
			for (int i = 0; i < sx.length; i++) {
				data[i] = Double.parseDouble(sx[i].split(Pattern.quote(","))[x]);
			}
		}

	}

	public double[] returnData() { // the get method for other classes access
		return data;
	}
}
