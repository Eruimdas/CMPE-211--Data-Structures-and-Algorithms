
package worksheet_4;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Heap;

public class worksheet_4_cmpe_211 {

	public static void main(String[] args) {
		MinHeap myHeap = new MinHeap(100);

		for (int i = 0; i < 5; i++) {
			myHeap.print();
			myHeap.getMin();
		}
		
		myHeap.print();
	}
}
