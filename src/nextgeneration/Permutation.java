package nextgeneration;

public class Permutation {
	// P = n! / (n-r)!
	// n: total number of objects
	// r: number of objects selected

	public static void swap(int[] a, int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	public static void reverse(int[] a, int from, int to) {
		int b = from, e = to;
		while (b < e) {
			swap(a, b, e);
			b++;
			e--;
		}
	}

	// Liet ke hoan vi
	public static boolean nextGeneration(int[] b, int n) {

		// If the given dataset is empty or contains only one element next_permutation
		// is not possible
		if (n <= 1)
			return false;

		int i = n - 2;
		// Find the first pair from the right where nums[i] < nums[i + 1]
		while (i >= 0 && b[i] > b[i + 1])
			i--;
		if (i < 0)
			return false;

		int k = n - 1;
		// Find the first element from the right greater than nums[i]
		while (k >= 0 && b[k] < b[i])
			k--;

		// if(k==i) return 0;

		swap(b, k, i);
		reverse(b, i + 1, n - 1);
		return true;
	}

	public static void printList(int[] a, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 3, max = 100;
		int[] a = new int[max + 1];

		for (int i = 0; i < n; i++)
			a[i] = i + 1;

		do {
			printList(a, n);
		} while (nextGeneration(a, n));
	}

}
