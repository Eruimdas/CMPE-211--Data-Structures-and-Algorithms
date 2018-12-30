import java.util.ArrayList;
import edu.princeton.cs.algs4.StdStats;

/*	
 * 	The goal is to identify some data traffic parameters, which can be
 *	used to describe the data traffic and that vary significantly
 *	from the normal behavior to the anomalous one with using 
 *  Statistical Approach.
 */

public class StatisticalAnomalyDetection {
	private static double[] data; // we created an empty double array attribute
	private static String datapath = "messages.txt"; // we created the data path attribute for collect the data
	private static int window = 10;  // initializing the value for at how many data points average must calculated.

	private static ArrayList<Integer> anomalyIndexes(double[] means) {
		// returns an ArrayList<Integer> that contains the indexes 
		
		ArrayList<Integer> indexList = new ArrayList<Integer>();

		double std = StdStats.stddev(means); // calculating the standart deviation
		double mean = StdStats.mean(means); // calculating the mean

		for (int i = 0; i < means.length; i++) {
			if ((Math.abs(means[i] - mean)) > (3 * std))// checking anomaly with 3-sigma rule
				
				indexList.add(i);
		}
		return indexList;
	}

	private static double[] rollingDifMeans(double[] data, double[] averages) {
		// subtracts the rollingAverage from each data point starting from 10th data point 
		// it starts from 9th index because the method rollingAverage calculates the
		// average from 10 data point before an index 
		double[] difference = new double[averages.length + window - 1];
		int k = 0;

		for (int i = 0; i < averages.length; i++) {
			difference[window - 1 + k] = data[window - 1 + i] - averages[i];
			k += 1;
		}

		return difference;
	}

	private static double[] rollingAverage(double[] data) {
		// writes the averages at every 10 data points before a data point to a double array 
		double[] rollingAverages = new double[data.length - window + 1];
		double sum = 0;

		for (int i = 0; i < window; i++) {
			sum += data[i]; 
		}
		// avg = total sum of all the numbers / number of items in the set
		rollingAverages[0] = sum / window; 	 
		int k = 1;							

		for (int i = window; i < data.length; i++) {
			sum -= data[i - window];
			sum += data[i];
			rollingAverages[k] = sum / window;
			k = k + 1; 
		}

		return rollingAverages;
	}
	
	public static void main(String args[]) {
		LoadData dataloader = new LoadData(datapath); // created an LoadData object to access the methods inside LoadData 
		data = dataloader.returnData(); // writing the messages.txt data in the double[]data
		double[] rollingAverages = rollingAverage(data); // writes the averages at every window=10 data points to the rollingAverages array
		double[] rollingMeans = rollingDifMeans(data, rollingAverages); // writes the difference of every 10 data points' average for data points in data
		ArrayList<Integer> indexes = anomalyIndexes(rollingMeans); // calculating the anomaly indexes using the difference between means and the data points 
		System.out.println("Anomaly Detection by 3 Sigma rule(Index numbers): " + indexes); // printing out the result.
	}

}
