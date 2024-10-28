package medium;

import java.util.HashSet;

// https://leetcode.com/problems/longest-square-streak-in-an-array/?envType=daily-question&envId=2024-10-28

public class Problem2501 {

	public static int longestSquareStreak(int[] nums) {
		HashSet<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int maxLength = -1;

		for (int num : nums) {
			int length = 0;
			long current = num;

			while (numSet.contains((int) current)) {
				length++;
				current *= current;
				if (current > Integer.MAX_VALUE)
					break;
			}

			if (length >= 2) {
				maxLength = Math.max(maxLength, length);
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestSquareStreak(new int[] { 4, 3, 6, 16, 8, 2 })); // 3
		System.out.println(longestSquareStreak(new int[] { 2, 3, 5, 6, 7 })); // -1
		System.out.println(longestSquareStreak(new int[] { 2, 4 })); // 2
		System.out.println(longestSquareStreak(new int[] { 3, 9, 81, 6561 })); // 4 // Index 43046721 out of bounds for
																				// length 100001
	}

}
