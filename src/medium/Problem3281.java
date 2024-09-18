package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3281 {

	public static int maxPossibleScore(int[] start, int d) {
		int res = -1;
		int low = 0;
		int high = Integer.MAX_VALUE;
		Arrays.sort(start);

		while (low <= high) {
			int mid = low + (high - low) / 2; // find mid is the result

			if (isValid(start, d, mid)) {
				res = mid;
				low = mid + 1;
			}

			else
				high = mid - 1;
		}

		return res;
	}

	private static boolean isValid(int[] nums, int d, int mid) {
		int n = nums.length;
		int prev = nums[0]; // the first integer is chosen after sorting

		// loop through n intervals [start[i], start[i] + d] to check if 'mid' is valid
		for (int i = 1; i < n; i++) {
			int nextChoice = prev + mid;
			if (nextChoice > nums[i] + d) // nextChoice = (prev + mid) is the next integer; it is not out of range
				return false;
			prev = Math.max(nums[i], nextChoice);
		}

		return true;
	}

	public static void main(String[] args) {
		// start = [6,0,3], d = 2, output = 4
		// intervals [6,8] [0,2] [3,5]
		// integers: 8, 0, and 4.

		System.out.println("Case 1: " + maxPossibleScore(new int[] { 6, 0, 3 }, 2));
		System.out.println("Case 2: " + maxPossibleScore(new int[] { 2, 6, 13, 13 }, 5));
	}

	/*
	 * Hint: Suppose that the answer is x. We can find a valid configuration of
	 * integers by sorting start, the first integer should be start[0], then each
	 * subsequent integer should be the smallest one in [start[i], start[i] + d]
	 * that is greater than last_chosen_value + x.
	 */

	/*
	 * Approach: Sorting: Sort the start array to arrange the values in increasing
	 * order for easier binary search.
	 * 
	 * Binary Search: Use binary search to find the largest possible minimum
	 * difference (mid) between consecutive values. The search range for mid is from
	 * 0 to start.back() - start.front() + d.
	 * 
	 * Check Function: For each mid, check if we can place all values such that the
	 * difference between consecutive values is at least mid and doesn't exceed
	 * start[i] + d. Adjust the search range based on this check.
	 */

	// https://leetcode.com/problems/maximize-score-of-numbers-in-ranges/solutions/5753373/easy-binary-search-simple-solution-beat-100
	// https://leetcode.com/problems/maximize-score-of-numbers-in-ranges/solutions/5755595/detailed-explanation-binary-search-java-beats-100/
}
