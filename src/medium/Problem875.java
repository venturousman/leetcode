package medium;

public class Problem875 {

	public static boolean isValid(int[] piles, int h, int mid) {
		int totalHours = 0;
		for (int i = 0; i < piles.length; i++) {
			totalHours += Math.ceil((double) piles[i] / mid);
		}
//		System.out.println(mid + " - " + totalHours);
		if (totalHours > h)
			return false;
		return true;
	}

	public static int findMax(int[] piles) {
		int maxElement = Integer.MIN_VALUE;
		int n = piles.length;
		for (int i = 0; i < n; i++)
			maxElement = Math.max(maxElement, piles[i]);
		return maxElement;
	}

	// https://leetcode.com/problems/koko-eating-bananas/?envType=study-plan-v2&envId=leetcode-75
	public static int minEatingSpeed(int[] piles, int h) {
//		Arrays.sort(piles);
		int ans = 0;
		int left = 1;
		int maxElement = findMax(piles);
		int right = maxElement;
//		int len = piles.length;
//		int right = piles[len - 1];
		while (left <= right) {
			int mid = (left + right) / 2;
			if (isValid(piles, h, mid)) {
				ans = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
//		System.out.println("1. " + left + " - " + right);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Case 1: " + minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8)); // expect the output = 4
		System.out.println("Case 1: " + minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 5)); // expect the output = 30
		System.out.println("Case 1: " + minEatingSpeed(new int[] { 30, 11, 23, 4, 20 }, 6)); // expect the output = 23
	}

}
