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

		long left = 0, right = 100 * 10 ^ 6 * 10 ^ 6;
		while (left < right) {
			long mid = left + (right - left) / 2;

			long repairedCars = 0;
			for (int r : ranks)
				repairedCars += (long) Math.sqrt(mid / r);

			if (repairedCars < cars)
				left = mid + 1;
			else
				right = mid;
		}

		return left;
	}

	public static void main(String[] args) {
		System.out.println(repairCars(new int[] { 4, 2, 3, 1 }, 10));
		System.out.println(repairCars(new int[] { 5, 1, 8 }, 6));
		System.out.println(repairCars(new int[] { 3, 3, 1, 2, 1, 1, 3, 2, 1 }, 58));
	}

}
