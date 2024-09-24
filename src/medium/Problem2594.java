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
			if (mins > max)
				max = mins;
		}
		return max;
	}

//	public static boolean isValid(int[] ranks, int cars, long mins) {
//		long total = 0;
//		if (total == mins)
//			return true;
//		return false;
//	}

	public static void process(int[] ranks, int cars, int[] assigned, int i) {
		int noMachines = ranks.length;
		int numMachineLeft = noMachines - (i + 1);
		int remainingCars = cars;
		if (i > 0) {
			for (int j = i - 1; j >= 0; j--) {
				remainingCars -= assigned[j];
			}
		}
		if (i == noMachines - 1) {
			assigned[i] = remainingCars;
//			printList(assigned);
			long mins = getMaxMinutes(ranks, assigned);
//			System.out.println(mins);
			if (mins < minValue) {
				minValue = mins;
			}
			return;
		}
//		if (i == noMachines) {
//			printList(assigned);
//			long mins = getMaxMinutes(ranks, assigned);
//			System.out.println(mins);
//			if (mins < minValue && remainingCars == 0) {
//				minValue = mins;
//			}
//			return;
//		}
		int avg = cars / noMachines;
//		int start = Math.min(1, avg);
		int start = avg;
		if (i > 0)
			start = 1;
		int end = remainingCars - numMachineLeft; // possible cars can assign to rank ith
		for (int c = end; c >= start; c--) {
			assigned[i] = c;
			process(ranks, cars, assigned, i + 1);
		}
	}

	// https://leetcode.com/problems/minimum-time-to-repair-cars/description/
	public static long repairCars(int[] ranks, int cars) {

		Arrays.sort(ranks);

		var assigned = new int[ranks.length]; // assign assigned[i] cars for machine ith;
		process(ranks, cars, assigned, 0);

//		System.out.println(minValue);

		return minValue;
	}

	public static void main(String[] args) {
//		System.out.println(repairCars(new int[] { 4, 2, 3, 1 }, 10));
//		System.out.println(repairCars(new int[] { 5, 1, 8 }, 6));
		System.out.println(repairCars(new int[] { 3, 3, 1, 2, 1, 1, 3, 2, 1 }, 58));
	}

}
