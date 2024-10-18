package medium;

public class Problem2044 {

	public static boolean createNextGeneration(int b[]) {
		int i = b.length - 1;
		while (i >= 0 && b[i] != 0)
			i--;
		if (i < 0)
			return false;
		b[i] = 1;
		for (int j = i + 1; j < b.length; j++)
			b[j] = 0;
		return true;
	}

	public static int countMaxOrSubsets2(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max |= nums[i];
		}
		int count = 0;
		var a = new int[nums.length];
		while (createNextGeneration(a)) {
//			printList(a);
			int bw = 0;
			for (int i = 0; i < a.length; i++) {
				if (a[i] == 1) {
					bw = bw | nums[i];
				}
			}
//			System.out.println("bitwise: " + bw);
			if (bw == max)
				count++;
		}
		return count;
	}

	// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/solutions/1525309/java-c-python-dp-solution/?envType=daily-question&envId=2024-10-18
	public static int countMaxOrSubsets1(int[] nums) {
		int max = 0, dp[] = new int[1 << 17];
		dp[0] = 1;
		for (int a : nums) {
			for (int i = max; i >= 0; --i)
				dp[i | a] += dp[i];
			max |= a;
		}
		return dp[max];
	}

	private static int res = 0;

	public static int countMaxOrSubsets(int[] nums) {
		res = 0;
		int maxOR = 0;
		for (int i = 0; i < nums.length; ++i)
			maxOR |= nums[i];
		// maxOR is now the maximum bitwise OR.
		maxSubset(nums, 0, 0, maxOR);
		return res;
	}

	private static void maxSubset(int[] arr, int i, int curOr, int maxOR) {
		if (i == arr.length) {
			if (curOr == maxOR)
				++res;
			return;
		}
		maxSubset(arr, i + 1, curOr | arr[i], maxOR); // include it
		maxSubset(arr, i + 1, curOr, maxOR); // skip it
	}

	public static void printList(int b[]) {
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

//		var b = new int[3];
//		printList(b);
//		while (createNextGeneration(b)) {
//			printList(b);
//		}

		System.out.println(countMaxOrSubsets(new int[] { 3, 1 }));
		System.out.println(countMaxOrSubsets(new int[] { 2, 2, 2 }));
		System.out.println(countMaxOrSubsets(new int[] { 3, 2, 1, 5 }));
	}

}
