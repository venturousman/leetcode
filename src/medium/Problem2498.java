package medium;

public class Problem2498 {

	// it can jump to any stone at most once
	// greedy
	public static int maxJump(int[] stones) {
		int res = stones[1] - stones[0];
		int n = stones.length;
		for (int i = 2; i < n; ++i)
			res = Math.max(res, stones[i] - stones[i - 2]);
		return res;
	}

	// https://leetcode.com/problems/frog-jump-ii/description/
	public static void main(String[] args) {
		System.out.println(maxJump(new int[] { 0, 2, 5, 6, 7 }));
		System.out.println(maxJump(new int[] { 0, 3, 9 }));
	}

}
