package medium;

import java.util.Arrays;

/*
 * 1 <= ranks.length <= 10^5
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 10^6
 */

public class Problem2594 {

	public static boolean isValid(int[] ranks, int cars, long mins) {
		if (mins % ranks[0] != 0)
			return false;

		var assigned2 = mins / ranks[0];
		var assigned = (long) Math.sqrt(assigned2);
		if (assigned > cars)
			return false;
		var remainCars = cars - assigned;
		var remainMachines = ranks.length - 1;
		if (remainCars % remainMachines == 0)
			return true;

		return false;
	}

	// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
	public static long repairCars(int[] ranks, int cars) {

//		Arrays.sort(ranks);

		long left = 1L;
		long right = 1L * 100 * 1000000 * 1000000;
		while (left < right) {
			long mid = left + (right - left) / 2;

			long repairedCars = 0;
			for (int r : ranks) {
				repairedCars += (long) Math.sqrt(1.0 * mid / r);
				if (repairedCars >= cars) {
					break; // Early exit if we've already repaired enough cars
				}
			}

			if (repairedCars < cars)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}

	public static void main(String[] args) {
//		System.out.println(repairCars(new int[] { 4, 2, 3, 1 }, 10));
//		System.out.println(repairCars(new int[] { 5, 1, 8 }, 6));
//		System.out.println(repairCars(new int[] { 3, 3, 1, 2, 1, 1, 3, 2, 1 }, 58));
//		System.out.println(repairCars(new int[] { 3 }, 52));
		System.out.println(repairCars(new int[] { 31, 31, 5, 19, 19, 10, 31, 18, 19, 3, 16, 20, 4, 16, 2, 25, 10, 16,
				23, 18, 21, 23, 28, 6, 7, 29, 11, 11, 19, 20, 24, 19, 26, 12, 29, 29, 1, 14, 17, 26, 24, 7, 11, 28, 22,
				14, 31, 12, 3, 19, 16, 26, 11 }, 736185));
	}

}
