package worksheet_1;

import edu.princeton.cs.algs4.Out;

public class out_example {
	public static void main(String[] args) {
		Out out = new Out();
		
		out.println("Trial");
		
		out = new Out("trial.txt");
		out.print("Trial to the text file");
	}
}
