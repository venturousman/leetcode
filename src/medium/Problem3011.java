package medium;

import java.util.Arrays;

public class Problem3011 {

	private static boolean isSorted(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				return false;
		}
		return true;
	}

	public static boolean canSortArray1(int[] nums) {
		boolean isDone = isSorted(nums);
		if (isDone)
			return true;

		int n = nums.length;
		boolean swapped = false;
		// BubbleSort
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - i - 1; j++) {
				int count1 = Integer.bitCount(nums[j]);
				int count2 = Integer.bitCount(nums[j + 1]);
				if (nums[j] > nums[j + 1] && count1 == count2) {
					// Swap arr[j] and arr[j + 1]
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
					swapped = true;
				}
			}
			// If no elements were swapped, the array is already sorted
			if (!swapped)
				break;
		}
		return isSorted(nums);
	}

	public static boolean canSortArray(int[] nums) {
		int n = nums.length;

		// Copy the original array to values
		int[] values = Arrays.copyOf(nums, n);

		// First Pass: Iterate from left to right
		// Goal: Move the maximum value of each segment as far right as possible
		for (int i = 0; i < n - 1; i++) {
			if (values[i] <= values[i + 1])
				continue;
			else {
				// Count the number of set bits using Integer.bitCount
				if (Integer.bitCount(values[i]) == Integer.bitCount(values[i + 1])) {
					// Swap them if they have the same number of set bits
					int temp = values[i];
					values[i] = values[i + 1];
					values[i + 1] = temp;
				} else
					return false; // Return false if they cannot be swapped
			}
		}

		// Second Pass: Iterate from right to left
		// Goal: Move the minimum value of each segment as far left as possible
		for (int i = n - 1; i >= 1; i--) {
			if (values[i] >= values[i - 1])
				continue;
			else {
				// Count the number of set bits using Integer.bitCount
				if (Integer.bitCount(values[i]) == Integer.bitCount(values[i - 1])) {
					// Swap them if they have the same number of set bits
					int temp = values[i];
					values[i] = values[i - 1];
					values[i - 1] = temp;
				} else
					return false; // Return false if they cannot be swapped
			}
		}

		// If both passes complete without returning false, the array can be sorted
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canSortArray(new int[] { 8, 4, 2, 30, 15 }));
		System.out.println(canSortArray(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(canSortArray(new int[] { 3, 16, 8, 4, 2 }));
	}

}
