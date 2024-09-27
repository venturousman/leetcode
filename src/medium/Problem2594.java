package medium;

import java.util.Arrays;

/*
 * 1 <= ranks.length <= 10^5
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 10^6
 */

public class Problem2594 {

	private static void printList(int[] a) {
		var s = new StringBuilder();
		for (int i = 0; i < a.length; i++) {
			s.append(a[i] + " ");
		}
		System.out.println(s.toString());
	}

	public static long getMaxMinutes(int[] ranks, int[] assigned) {
		long max = 0;
		for (int i = 0; i < ranks.length; i++) {
			long mins = ranks[i] * assigned[i] * assigned[i];
			if (mins > max)
				max = mins;
		}
		return max;
	}

	// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
	public static long repairCars(int[] ranks, int cars) {

		Arrays.sort(ranks);

		var assigned = new int[ranks.length]; // assign assigned[i] cars for machine ith;
		int remainCars = cars;
		int avg = cars / ranks.length;
		for (int i = ranks.length - 1; i > 0; i--) {
			assigned[i] = avg;
			remainCars -= avg;
		}
		assigned[0] = remainCars;
		long result = getMaxMinutes(ranks, assigned);

		printList(assigned);

		return result;
	}

	public static void main(String[] args) {
//		System.out.println(repairCars(new int[] { 4, 2, 3, 1 }, 10));
//		System.out.println(repairCars(new int[] { 5, 1, 8 }, 6));
		System.out.println(repairCars(new int[] { 3, 3, 1, 2, 1, 1, 3, 2, 1 }, 58));
	}

}
