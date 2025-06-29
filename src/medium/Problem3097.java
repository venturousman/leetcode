package medium;

// https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2024-11-10
// sliding window
public class Problem3097 {

	public static int minimumSubarrayLength(int[] nums, int k) {
		int n = nums.length;

		// int max = 0, min = Integer.MAX_VALUE;
		// for (int i = 0; i < n; i ++) {
		// if (nums[i] < min) min = nums[i];
		// if (nums[i] > max) max = nums[i];
		// }

		// if (min > k || max > k) return 1;

		// Initialize current sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting and ending indexes
		int start = 0, end = 0;
		while (end < n) {
			// Keep adding array elements while current sum is smaller than or equal to x
			while (curr_sum <= k && end < n) {
				// System.out.println("in while 1: " + nums[end]);
				curr_sum |= nums[end++];
			}
			System.out.println(start + " - " + end + " -- " + curr_sum);

			// If current sum becomes greater than x.
			while (curr_sum > k && start < n) {
				// Update minimum length if needed
				if (end - start < min_len)
					min_len = end - start;

				// remove starting elements
				curr_sum &= ~nums[start++];
			}
		}
		return min_len == n + 1 ? -1 : min_len;

	}

	public static void main(String[] args) {
		System.out.println(minimumSubarrayLength(new int[] { 1, 2, 3 }, 2));
	}

}
