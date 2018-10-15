package worksheet_1;

import java.util.ArrayList;
import edu.princeton.cs.algs4.*;

public class worksheet_1_cmpe_211 {

	public static void main(String[] args) {

//		StdOut.print("Type a string: ");
//        String s = StdIn.readString();
//        StdOut.println("Your string was: " + s);
//        StdOut.println();
//        StdOut.print("Type an int: ");
//        int a = StdIn.readInt();
//        StdOut.println("Your int was: " + a);
//        StdOut.println();
//        StdOut.print("Type a boolean: ");
//        boolean b = StdIn.readBoolean();
//        StdOut.println("Your boolean was: " + b);
//        StdOut.println();
//        StdOut.print("Type a double: ");
//        double c = StdIn.readDouble();
//        StdOut.println("Your double was: " + c);
//        StdOut.println();
		// at one time
		In in = new In("https://introcs.cs.princeton.edu/java/stdlib/InTest.txt");
		String s = in.readAll();
		System.out.println(s);
		// as separate lines
		in = new In("https://introcs.cs.princeton.edu/java/stdlib/InTest.txt");
		String[] s2 = in.readAllLines();
		printArray(s2);
		// reading as strings
		in = new In("Week3TestFile.txt");
		String[] s3 = in.readAllStrings();
		printArray(s3);
		// reading as characters 
		in = new In("Week3TestFile.txt");
		ArrayList<Character> c = new ArrayList<Character>();
		while (in.hasNextChar()) {
			c.add(in.readChar());
		}
		System.out.println(c);

//		System.out.println(greatestCommonDivisor(35, 20));
//		System.out.println(myFactorial(5));
	}

	public static int greatestCommonDivisor(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			System.out.println(a % b + ", " + a);
			return greatestCommonDivisor(b, a % b);
		}
	}

	public static int myFactorial(int a) {
		if (a == 1) {
			return 1;
		} else {
			return a * myFactorial(a - 1);
		}
	}

	public static void printArray(String[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

}
