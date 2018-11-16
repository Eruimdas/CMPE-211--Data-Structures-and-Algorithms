import java.util.ArrayList;
import edu.princeton.cs.algs4.Quick;

public class greedyalgo {
	static ArrayList x = new ArrayList();
	public static int pointer = 0;

	public static void main(String[] args) {
		// initiating values of start and finish times.
		Comparable[] s = { 8, 1, 0, 3, 5, 5, 3, 2, 6, 8 };
		// 				    {0,1,2, 3,3, 5,5, 6, 8, 8}
		// f1 array is acquired from hand calculation of changing variables with
		// the same index as s. I mean, if two indexes changed in s array,
		// they also changed in f array to acquire f1 array.
		Comparable[] f1 = { 6, 4, 10, 5, 13, 9, 8, 11, 12, 13 };
		Comparable[] f = { 12, 4, 6, 5, 9, 8, 13, 10, 11, 13 };
		// Using quick sort algorithm to sort first array.
		Quick.sort(s);
		myGreedy(s, f1);
		System.out.println(x.toString());
	}


	public static void compareComparable(Comparable[] s, Comparable[] f) {
		// comparing the 1 3rd of the start array, in order to find the event
		// which has minimum duration in the first hours of the day.
		int min = (int) f[0] - (int) s[0];
		for (int i = 1; i < s.length / 3; i++) {
			if (min > (int) f[i] - (int) s[i]) {
				min = (int)f[i] - (int)s[i];
				pointer = i;
			}
		}
	}

	public static void myGreedy(Comparable[] s, Comparable[] f) {
		compareComparable(s, f);
		// after comparing in compareComparable method, assign the most 
		// efficient event as first attended event. 
		x.add(s[pointer]);
		for (int i = 0; i < s.length; i++) {
			if (f[pointer].compareTo(s[i]) <= 0) {
				// if an event has another event which starting at the same time 
				// and if it's finish time is less than the first one,
				// choose the one who finishes early.
				if (s[i].equals(s[i + 1])) {
					if (f[i].compareTo(f[i + 1]) <= 0) {
						x.add(s[i + 1]);
						pointer = i + 1;
					}
				} else {
					x.add(s[i]);
					pointer = i;
				}

			}
		}
	}
}