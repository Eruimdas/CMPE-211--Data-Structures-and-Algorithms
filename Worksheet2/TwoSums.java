package worksheet_2;

public class TwoSums {
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
					if (a[i] + a[j] == 0) {
						count++;
						// System.out.println(a[i] + " " + a[j] + " " + a[k]);
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,-2,4,5,6};
		System.out.println(count(a));
	}
}
