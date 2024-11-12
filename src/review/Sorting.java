package review;

import java.util.Arrays;

// https://visualgo.net/en/sorting?slide=1

public class Sorting {

	// no more space, O(n^2)
	private static void bubbleSort(int[] a) {
		int n = a.length;
		// lặp đến khi k còn 2 ptu nào thỏa mãn
		// -> số lần lặp k quá n - 1 lần, do 1 ptu chỉ có thể nổi lên trên k quá n - 1 lần
		for (int i = 0; i < n; i++) {
			// xet 2 ptu lien tiep, neu pt sau < ptu truoc, swap
			// ptu nhỏ hơn sẽ nổi lên trên
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					// swap
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 29, 10, 14, 37, 14 };
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

}
