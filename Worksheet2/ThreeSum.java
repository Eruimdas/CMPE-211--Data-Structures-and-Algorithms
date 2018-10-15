package worksheet_2;


public class ThreeSum {
	public static int count(int[] a) {
		int n = a.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (a[i] + a[j] + a[k] == 0) {
						count++;
						// System.out.println(a[i] + " " + a[j] + " " + a[k]);
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,-3,4,5,6};
		System.out.println(count(a));
	}
}