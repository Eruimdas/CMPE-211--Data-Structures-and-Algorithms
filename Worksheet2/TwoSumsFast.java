package worksheet_2;
import java.util.Arrays;

public class TwoSumsFast {
	public static int count(int[] a) {
		int n = a.length;
		Arrays.sort(a);
		int count = 0;
		for (int i = 0; i < n; i++) {
				int k = Arrays.binarySearch(a, -(a[i]));
				if (k > i) {
					count++;
					// System.out.println(a[i] + " " + a[j] + " " + a[k]);
				}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,-2,4,5,6};
		System.out.println(count(a));
	}
}
