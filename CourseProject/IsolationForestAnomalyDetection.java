import java.lang.Math;
import edu.princeton.cs.algs4.StdRandom;
import java.util.ArrayList;

public class IsolationForestAnomalyDetection {

	private double[][] data; // we created an empty double array attribute
	private int isolated_index; // index number which will be calculated as an anomaly
	private int level; // iteration number counter
	public int iso; // getting the calculated isolated_index to a variable, to be seen as public.
	private double min, max; // minimum and maximum items of the list

	// Constructor, calling the method.
	public IsolationForestAnomalyDetection(double[][] data, double fraction) {

		this.data = subsampling(data, fraction);
		iso = recursive_partition(data, (int) (Math.log(data.length) / Math.log(2)), 1, "start");

	}

//	recursive_partition creates a decision tree that strives to correctly 
//	classify members of the population by splitting it into sub-populations 
//	based on several dichotomous independent variables.
	private int recursive_partition(double[][] data, int depth, int level, String info) {
		if (level == depth)
			return -1;

		// randomly selecting horizontal or vertical parts to be split.
		int f = (int) StdRandom.uniform(2);
		// getting the randomized value between min and max values of selected parts.
		double cut = fControl(f, data);

		// assigning level value to global level value, to get on which iteration number
		// returned.
		this.level = level;

		// creating the arrays, which are smaller and greater than the cut value,
		// and if smaller array's length is 1, returning the index, which
		// indicates that the smaller index is isolated. Same for the greater.
		double[][] smaller = getSmaller(data, cut, f);
		if (smaller.length == 1)
			return (int) smaller[0][0];

		double[][] greater = getGreater(data, cut, f);
		if (greater.length == 1)
			return (int) greater[0][0];

		// If in smaller or greater, there couldn't be any isolation
		// try to get smaller and greater partition in the same way
		// calculated above.
		isolated_index = recursive_partition(smaller, depth, level + 1, "small");
		if (isolated_index != -1)
			return isolated_index;

		isolated_index = recursive_partition(greater, depth, level + 1, "greater");
		if (isolated_index != -1)
			return isolated_index;

		return -1;
	}

	// score returns the how many iteration needed to isolate the variable.
	public int score() {
		if (iso != -1) {
			return level;

		} else {
			return Integer.MAX_VALUE;
		}
	}

	private double[][] getSmaller(double[][] data, double cut, int f) {

		// returns the smaller elements
		ArrayList<Double> temp = new ArrayList<Double>();
		ArrayList<Double> temp2 = new ArrayList<Double>();

		// checks if the value is smaller, if smaller appends it to the array list.
		for (int i = 0; i < data.length; i++) {
			if (data[i][f] < cut) {
				temp.add(data[i][0]);
				temp2.add(data[i][1]);
			}
		}

		// we write the values from a double array to two ArrayLists
		double[][] temp3 = new double[temp.size()][2];

		for (int y = 0; y < temp.size(); y++) {
			temp3[y][0] = temp.get(y);
			temp3[y][1] = temp2.get(y);
		}
		return temp3;
	}

	private double[][] getGreater(double[][] data, double cut, int f) {
		// returns the greater element
		ArrayList<Double> temp = new ArrayList<Double>();
		ArrayList<Double> temp2 = new ArrayList<Double>();
		for (int i = 0; i < data.length; i++) {
			if (data[i][f] >= cut) {
				temp.add(data[i][0]);
				temp2.add(data[i][1]);
			}
		}
		// we write the values from a double array to two ArrayLists
		double[][] temp3 = new double[temp.size()][2];

		for (int y = 0; y < temp.size(); y++) {
			temp3[y][0] = temp.get(y);
			temp3[y][1] = temp2.get(y);
		}

		return temp3;
	}

	private double fControl(int f, double[][] data) {
		// controls the f value
		min = data[0][f];
		max = data[0][f];
		for (int i = 0; i < data.length; i++) {
			if (data[i][f] < min)
				min = data[i][f];
			// controlling the minimum value of the array.
		}
		for (int i = 0; i < data.length; i++) {
			if (data[i][f] > max)
				max = data[i][f];
			// controlling the maximum value of the array.
		}
		double cut = StdRandom.uniform(min, max); // getting a Random Double value between minimum and maximum values.
		return cut; // returning value.
	}

	private double[][] subsampling(double[][] data, double fraction) {

		// calculating the fraction number for the data set given.
		int fraction_number = (int) (data.length * fraction);
		int max_factor = data.length;
		// creating a temporary array to insert randomized values.
		double[][] temp = new double[fraction_number][2];

		// assigning values as randomized into the temporary array.
		for (int i = 0; i < fraction_number; i++) {
			int index = StdRandom.uniform(max_factor);
			temp[i][0] = data[index][0];
			temp[i][1] = data[index][1];
		}

		// then returning the temporary array.
		return temp;
	}

}
