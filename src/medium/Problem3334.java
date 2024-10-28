package medium;

// https://leetcode.com/problems/find-the-maximum-factor-score-of-array/description/

public class Problem3334 {
	// uoc chung lon nhat
	public static long gcd(long a, long b) {
		while (b != 0) {
			long temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// Method to calculate LCM - boi chung nho nhat
	public static long lcm(long a, long b) {
		return Math.abs(a * b) / gcd(a, b);
	}

	public static long maxScore(int[] nums) {
		if (nums.length == 0)
			return 0;

		long max = 0;

		for (int i = -1; i < nums.length; i++) {
			long mgcd = 0;
			long mlcm = 1;
			for (int j = 0; j < nums.length; j++) {
				if (j == i)
					continue;

				mgcd = gcd(mgcd, nums[j]);
				mlcm = lcm(mlcm, nums[j]);
			}
			long factor = mgcd * mlcm;
			max = Math.max(max, factor);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxScore(new int[] { 2, 4, 8, 16 })); // 64
		System.out.println(maxScore(new int[] { 1, 2, 3, 4, 5 })); // 60
		System.out.println(maxScore(new int[] { 3 })); // 9
		System.out.println(maxScore(new int[] { 2, 29 })); // expect 841
		System.out.println(maxScore(new int[] { 16, 25, 7, 27, 11, 13, 17, 19, 23, 29 })); // 2329089562800

	}

}
