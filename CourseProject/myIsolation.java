import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.MinPQ;

public class myIsolation {

	private static int sum = 0;
	private static double[][] data; // We created an empty double array for datas
	private static double[] mydata;// We created an empty array for our datas
	private static LinkedList<Double> mylist;// we created a double link list
	private static MinPQ<Double> myheap; // we use minPQ type for our minimum
	private static ST<Integer, LinkedList<Double>> symbol1 = new ST<Integer, LinkedList<Double>>();// Symbol Table named
																									// symbol1 with a
																									// integer and link
																									// list

	public static void main(String[] args) {// main method

		myIsolation h = new myIsolation();// new object
		h.DataLoader("test_anomaly_data.csv");// we get our data by using data loader method
		// creating the isolation forest from separate trees.
		for (int i = 0; i < 100; i++) {
			IsolationForestAnomalyDetection a = new IsolationForestAnomalyDetection(data, 0.85);
			// create a new isolation tree anomaly detection object with the values
			if (symbol1.contains(a.iso)) { // if symbol table contains values
				symbol1.get(a.iso).insert((double) a.score());// update the linked list score values.
			} else {// if it is not contains
				mylist = new LinkedList<Double>();// create a new double link list
				mylist.insert((double) a.score());// we put the scores to this list
				symbol1.put(a.iso, mylist);// we put the values to the symbol table
			}
		}

		ST<Integer, Double> means = h.calcMean(symbol1);// created a symbol table with calculated means of the previous
		// one's linked list attribute
		Iterable<Integer> means_keys = means.keys();// taking the Iterable key values from the symbol table.
		myheap = new MinPQ<Double>(means.size());// we are creating a minimum priority queue.
		ST<Integer, Double> average_try = new ST<Integer, Double>();

		// using the forEach method, which implemented in java sdk8,
		// this iteration gets the every key, and adds values to the priority queue,
		// and with the index, to the average_try symbol table.
		means_keys.forEach(key -> {
			average_try.put(key, means.get(key));
			myheap.insert(means.get(key));
		});

		double[] xmeans = new double[3];// we create an array has 3 component
		for (int y = 0; y < 3; y++) {
			xmeans[y] = (double) myheap.min();// using heap, getting the minimum 3 keys.
			myheap.delMin();
		}

		Iterable<Integer> average_keys = average_try.keys();

		System.out.println("Anomaly Detection by Isolation Algorithm is: ");
		// forEach key again, trying to find 3 smallest values in the symbol list.
		average_keys.forEach(key -> {
			// there might be multiple values indexed with the same average,
			// so in order to print just 3 values this statement is added.
			if (sum < 3) {
				if (containIndex(average_try.get(key), xmeans) != Integer.MIN_VALUE) {
					System.out.println("Key is: " + key + " value is: " + average_try.get(key));
					sum++;
				}
			}

		});
	}

	private static int containIndex(double key, double[] number) {
		// we are checking if the key value inside of the
		// array or not
		for (int i = 0; i < number.length; i++) {
			if (key == number[i])
				return i;
		}
		return Integer.MIN_VALUE;// and return the value

	}

	private ST<Integer, Double> calcMean(ST<Integer, LinkedList<Double>> st) {

		// the method that calculates mean of the
		// symbol table

		ST<Integer, Double> temp = new ST<Integer, Double>();// we create temporary symbol table
		Iterable<Integer> mykeys = st.keys();

		mykeys.forEach(key -> {
			temp.put(key, calcListMean(st.get(key)));
		});

		return temp;// return the temporary symbol table
	}

	private double calcListMean(LinkedList<Double> ll) {
		// it is using for calculating mean of a list
		double total = 0;
		for (int i = 0; i < ll.size(); i++) {
			total += ll.get(i);
		}

		return total / ll.size();// returning the average value
	}

	private void DataLoader(String datapath) {

		// it is using for taking data from given text file

		LoadData dataloader = new LoadData(datapath);
		mydata = dataloader.returnData();// we collect the data
		data = new double[mydata.length][2];// and put the inside of the array

		for (int i = 0; i < mydata.length; i++) {
			data[i][0] = i;
			data[i][1] = mydata[i];
		}
	}
}
