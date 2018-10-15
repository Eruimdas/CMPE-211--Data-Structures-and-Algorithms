package worksheet_1;

import edu.princeton.cs.algs4.StdStats;

public class stats_example {
	public static void main(String[] args) {
		double[] d = { .12, .15, .17, .13, .24, .26, .35 };
		System.out.println(StdStats.min(d));
		System.out.println(StdStats.max(d));
		System.out.println(StdStats.var(d));
		System.out.println(StdStats.mean(d));
		System.out.println(StdStats.stddev(d));
		StdStats.plotBars(d);
		StdStats.plotPoints(d);
		StdStats.plotLines(d);

	}
}
