package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3309 {

	// way 2nd
	/*
	 * Convert the given integer array to an array of Integer objects to utilize a
	 * custom comparator for sorting. Sort the integers based on their binary string
	 * representations in such a way that concatenating them results in the largest
	 * possible binary number. This is achieved by comparing combined binary strings
	 * in both possible orders. After sorting, concatenate the binary
	 * representations of the integers in the sorted order. Convert the final
	 * concatenated binary string back to an integer and return it.
	 */
	public static int maxGoodNumber2(int[] nums) {
		Integer[] integerNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

		Arrays.sort(integerNums, (a, b) -> {
			String binA = Integer.toBinaryString(a);
			String binB = Integer.toBinaryString(b);
			return (binB + binA).compareTo(binA + binB);
		});

		StringBuilder binaryConcatenation = new StringBuilder();

		for (int num : integerNums) {
			binaryConcatenation.append(Integer.toBinaryString(num));
		}

		return Integer.parseInt(binaryConcatenation.toString(), 2);
	}

	// Brute Force
	public static int maxGoodNumber1(int[] nums) {
		int base = 2;
		List<String> snums = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			String s = Integer.toString(nums[i], base);
//			System.out.println(s);
			snums.add(s);
		}

		int max = 0;
		String ssum = snums.get(0) + snums.get(1) + snums.get(2);
		Integer sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		ssum = snums.get(0) + snums.get(2) + snums.get(1);
		sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		ssum = snums.get(1) + snums.get(0) + snums.get(2);
		sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		ssum = snums.get(1) + snums.get(2) + snums.get(0);
		sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		ssum = snums.get(2) + snums.get(0) + snums.get(1);
		sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		ssum = snums.get(2) + snums.get(1) + snums.get(0);
		sum = Integer.parseInt(ssum, base);
		max = Math.max(max, sum);

		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxGoodNumber1(new int[] { 1, 2, 3 }));
		System.out.println(maxGoodNumber1(new int[] { 2, 8, 16 }));
		System.out.println(maxGoodNumber1(new int[] { 1, 38, 1 }));
		
		System.out.println(maxGoodNumber2(new int[] { 1, 2, 3 }));
		System.out.println(maxGoodNumber2(new int[] { 2, 8, 16 }));
		System.out.println(maxGoodNumber2(new int[] { 1, 38, 1 }));
	}

}
