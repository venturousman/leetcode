package review;

import java.util.Arrays;

// https://visualgo.net/en/sorting?slide=1

public class Sorting {

	// no more space, O(n^2)
	private static void bubbleSort(int[] a) {
		int n = a.length;
		// step 2. lặp đến khi k còn 2 ptu nào thỏa mãn
		// -> số lần lặp k quá n - 1 lần, do 1 ptu chỉ có thể nổi lên trên k quá n - 1
		// lần
		for (int i = 0; i < n; i++) {
			// step 1. xet 2 ptu lien tiep, neu pt sau < ptu truoc, swap
			// -> ptu nhỏ hơn sẽ nổi lên trên
			for (int j = n - 1; j > i; j--) {
				if (a[j] < a[j - 1]) {
					// swap
					int tmp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = tmp;
				}
			}
		}
	}

	// Idea: ta sẽ sxếp lần lượt từng đoạn gồm 1 ptử đầu tiên, 2 ptử đầu tiên, ..., N ptử.
	// giả sử đã sxep xong i ptu, -> tim vi tri phù hợp của ptu i+1 và "chèn" nó vào
	// O(n^2)
	private static void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			// Tìm vị trí phù hợp cho i
			int j = i;
			while (j > 0 && a[i] < a[j - 1])
				--j;

			// Đưa i về đúng vị trí, move các ptu qua phải
			int tmp = a[i]; // giu lai gia tri a[i]
			for (int k = i; k > j; k--)
				a[k] = a[k - 1];
			a[j] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 29, 10, 14, 37, 14 };
		System.out.println(Arrays.toString(a));
//		bubbleSort(a);
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
