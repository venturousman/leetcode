package medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * 1 <= ranks.length <= 10^5
 * 1 <= ranks[i] <= 100
 * 1 <= cars <= 10^6
 */

public class Problem2594 {

	private static long minValue = Long.MAX_VALUE;
	
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
			if (mins > max) max = mins;
		}
		return max;
	}
	
	public static boolean isValid(int[] assigned, int cars) {
		int total = 0;
		for (int i = 0; i < assigned.length; i++) {
			total += assigned[i];
		}
		return total == cars;
	}

	public static void Try(int[] ranks, int cars, int remainingCars, int[] assigned, int i) {
//		long mins = calculateMinutes(ranks, assigned);
//		if (mins > minValue) return;
		if (i == ranks.length) {
//			printList(assigned);
			boolean isValid = isValid(assigned, cars);
//			System.out.println(isValid);
			if (!isValid) return;
//			printList(assigned);
			long mins = getMaxMinutes(ranks, assigned);
//			System.out.println(mins + "\n ---");
			if (mins < minValue) {
				minValue = mins;
			}
			return;
		}
		for (int c = remainingCars; c > 0; c--) {
			assigned[i] = c;
			int newRemainingCars = remainingCars - c;
			Try(ranks, cars, newRemainingCars, assigned, i + 1);
		}
	}

	// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
	public static long repairCars(int[] ranks, int cars) {

		Arrays.sort(ranks);

		var assigned = new int[ranks.length]; // assign assigned[i] cars for car ith;

		Try(ranks, cars, cars, assigned, 0);
		
//		System.out.println(minValue);

		return minValue;
	}

	public static void main(String[] args) {
		System.out.println(repairCars(new int[] { 4, 2, 3, 1 }, 10));
		System.out.println(repairCars(new int[] { 5, 1, 8 }, 6));
	}

}
