package worksheet_4;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.StdRandom;

public class MinHeap {

	Comparable[] myList, tryout;
	private int pointer = 0;

	public MinHeap(int x) {
		myList = new Comparable[x];
		for (int i = 0; i < x; i++) {
			myList[i] = StdRandom.uniform(100);
		}
		Heap.sort(myList);
	}

	public void getMin() {
		System.out.println(myList[0]);
		tryout = myList;
		myList = new Comparable[tryout.length - 1];

		for (int i = 1; i <= myList.length; i++) {
			myList[i - 1] = tryout[i];
		}
	}

	public void print() {
		System.out.print("{");
		for (int i = 0; i < myList.length; i++) {
			if (i == (myList.length - 1))
				System.out.print(myList[i]);
			else
				System.out.print(myList[i] + ", ");
		}
		System.out.print("}\n");
	}
}
