package medium;

// https://leetcode.com/problems/longest-square-streak-in-an-array/?envType=daily-question&envId=2024-10-28

public class Problem2501 {
	
	public static int longestSquareStreak(int[] nums) {
		int size = 100001;
		int[] check = new int[size];
		for (int i = 0; i < nums.length; i++) {
			check[nums[i]]++;
		}

		int len = -1;
		for (int i = 2; i < size; i++) {
			if (check[i] > 0) {
//				System.out.println(i);
				int count = 1;
				int k = i;
//				System.out.println(k);
				while (k * k < size && check[k * k] > 0) {
					count++;
					k = k * k;
//					System.out.println(k);
				}
				if (count >= 2 && count > len)
					len = count;
//				System.out.println();
			}
		}
		return len;
	}

	public static void main(String[] args) {
		System.out.println(longestSquareStreak(new int[] { 4, 3, 6, 16, 8, 2 })); // 3
		System.out.println(longestSquareStreak(new int[] { 2, 3, 5, 6, 7 })); // -1
		System.out.println(longestSquareStreak(new int[] { 2, 4 })); // 2
		System.out.println(longestSquareStreak(new int[] { 3, 9, 81, 6561 })); // 4 // Index 43046721 out of bounds for length 100001
	}

}
