package nextgeneration;

public class Permutation {
	// P = n! / (n-r)!
	// n: total number of objects
	// r: number of objects selected

	public static void swap(int a[], int from, int to) {
		int temp = a[from];
		a[from] = a[to];
		a[to] = temp;
	}

	public static void reverse(int a[], int from, int to) {
		int b = from, e = to;
		while (b < e) {
//			swap(a[b], a[e]);
			swap(a, b, e);
//			int temp = a[b];
//			a[b] = a[e];
//			a[e] = temp;

			b++;
			e--;
		}
	}

	// Liet ke hoan vi
	public static boolean nextGeneration(int b[], int n) {
		int i = n - 1;
		while (i > 0 && b[i] > b[i + 1])
			i--;
		if (i == 0)
			return false;

		int k = n;
		while (b[k] < b[i])
			k--;

		// if(k==i) return 0;

//		HoanVi(b[k], b[i]);
		swap(b, k, i);
		// swap
//		int temp = b[k];
//		b[k] = b[i];
//		b[i] = temp;

		reverse(b, i + 1, n);

		return true;
	}

	public static void printList(int[] a, int n) {
		for (int i = 1; i <= n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 4, max = 100;
		int[] a = new int[max + 1];

		for (int i = 1; i <= n; i++)
			a[i] = i;

		printList(a, n);

		while (nextGeneration(a, n)) {
			printList(a, n);
		}
	}

}
