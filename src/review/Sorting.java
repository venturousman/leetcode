package review;

import java.util.Arrays;

// https://visualgo.net/en/sorting?slide=1

public class Sorting {

	// no more space, O(n^2)
	private static void bubbleSort(int[] a) {
		int n = a.length;
		// step 2. lặp đến khi k còn 2 ptu nào thỏa mãn
		// -> số lần lặp k quá n-1 lần, do 1 ptu chỉ có thể nổi lên trên k quá n-1 lần
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

	// Idea: ta sẽ sxếp lần lượt từng đoạn gồm 1 ptử đầu tiên, 2 ptử đầu tiên, ...,
	// N ptử.
	// giả sử đã sxep xong i ptu, -> tim vi tri phù hợp của ptu i+1 và "chèn" nó vào
	// O(n^2)
	private static void insertionSort(int[] a) {
		int n = a.length;
		// ptu đầu tiên đã sxep rồi
		for (int i = 1; i < n; i++) {
			int tmp = a[i]; // giu lai gia tri a[i]
			// Tìm vị trí phù hợp cho i
			int j = i;
			while (j > 0 && tmp < a[j - 1]) {
				a[j] = a[j - 1]; // đưa i về đúng vị trí, move các ptu qua phải
				--j;
			}
			a[j] = tmp;
		}
	}

	// lượt 1, tìm ptu nhỏ nhất trong dãy a[1..n], swap nó vs a[1], khi đó a[1] là
	// ptu nhỏ nhất
	// lượt 2, tìm ptu nhỏ nhất trong dãy a[2..n], swap nó vs a[2], ...
	// ...
	private static void selectionSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int jmin = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[jmin])
					jmin = j;
			}
			if (jmin != i) {
				// swap
				int tmp = a[i];
				a[i] = a[jmin];
				a[jmin] = tmp;
			}
		}
	}

	// pros: O(N*logN), stable
	// cons: more space to store
	private static void mergeSort(int[] a) {

	}

	public static void main(String[] args) {
//		int[] a = { 29, 10, 14, 37, 14 };
		// 4,2,4,1
		int[] a = { 7, 2, 8, 4, 3, 2, 1, 8 };
		System.out.println(Arrays.toString(a));
//		bubbleSort(a);
//		insertionSort(a);
		selectionSort(a);
		System.out.println(Arrays.toString(a));

		System.out.println("----------------------");

//		int[] b = { 59, 41, 35, 27, 14 };
//		System.out.println(Arrays.toString(b));
////		bubbleSort(b);
////		insertionSort(b);
//		selectionSort(b);
//		System.out.println(Arrays.toString(b));
	}

}
