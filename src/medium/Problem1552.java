package medium;

import java.util.Arrays;

public class Problem1552 {
	/*
	 * Constraints: n == position.length. 2 <= n <= 10^5. 1 <= position[i] <= 10^9.
	 * All integers in position are distinct. 2 <= m <= position.length
	 */

	public static boolean isValidForce(int[] position, int m, int predictedForce) {
		int count = 1;
		int last = position[0];
		for (int i = 0; i < position.length; i++) {
			if (position[i] - last >= predictedForce) {
				count++;
				last = position[i];
			}
			if (count >= m) {
				return true;
			}
		}
		return false;
	}

	// https://leetcode.com/problems/magnetic-force-between-two-balls/
	public static int maxDistance(int[] position, int m) {
		int n = position.length;
		Arrays.sort(position);

		int ans = 1;
		int left = 1;
		int right = (position[n - 1] - position[0]) / (m - 1);

		while (left <= right) {
			int mid = (left + right) / 2;
			boolean isValid = isValidForce(position, m, mid);
			if (isValid) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("Case 1: " + maxDistance(new int[] { 1, 2, 3, 4, 7 }, 3)); // expected output = 3
		System.out.println("Case 2: " + maxDistance(new int[] { 5, 4, 3, 2, 1, 1000000000 }, 2)); // expected output =
		// 999999999
	}

}
