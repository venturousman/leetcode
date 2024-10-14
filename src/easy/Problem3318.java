package easy;

import java.util.*;

// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/description/

public class Problem3318 {

	public static int sumTopXFrequent(int[] nums, int x, int begin, int end) {
		// Step 1: Count the frequency of each element using a HashMap
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int i = begin; i <= end; i++) {
			int num = nums[i];
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// Step 2: Sort the entries by frequency
		// and get the top X most frequent elements
		List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
		sortedEntries.sort((a, b) -> {
			var res = b.getValue().compareTo(a.getValue());
			if (res == 0) {
				return b.getKey().compareTo(a.getKey());
			}
			return res;
		});

		// Get the top X frequent elements
		Set<Integer> topX = new HashSet<>();
		for (int i = 0; i < Math.min(x, sortedEntries.size()); i++) {
			topX.add(sortedEntries.get(i).getKey());
		}

		// Step 3: Filter the original array to keep only the top 2 frequent elements
//		List<Integer> result = new ArrayList<>();
		int sum = 0;
		for (int i = begin; i <= end; i++) {
			int num = nums[i];
			if (topX.contains(num)) {
//				result.add(num);
				sum += num;
			}
		}

		return sum;
	}

	public static int[] findXSum(int[] nums, int k, int x) {
		var result = new int[nums.length - k + 1];
//		System.out.println(nums.length - k + 1);
		for (int i = 0; i < nums.length - k + 1; i++) {
			int sum = sumTopXFrequent(nums, x, i, i + k - 1);
//			System.out.println(sum);
			result[i] = sum;
		}
//		System.out.println();
		return result;
	}

	public static void printList(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
//		System.out.println();
		var ans = findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2);
//		var ans = findXSum(new int[] { 3, 8, 7, 8, 7, 5 }, 2, 2);
		printList(ans);
	}

}
