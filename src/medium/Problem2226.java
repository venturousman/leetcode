package medium;

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/

public class Problem2226 {

	public static boolean check(int[] candies, long k, long candiesToAllocate) {
		if (candiesToAllocate == 0)
			return false;
		long count = 0; // kids
		for (int i = 0; i < candies.length; i++) {
			count += candies[i] / candiesToAllocate;
			if (count >= k)
				return true;
		}
		return false;
	}

	public static int maximumCandies(int[] candies, long k) {
		long sum = 0;
		for (int i = 0; i < candies.length; i++) {
			sum += candies[i];
		}
		if (sum < k)
			return 0;

		int ans = 0;
		int left = 1;
		int right = (int) (sum / k); // 10000001;
		while (left <= right) {
			int mid = left + (right - left) / 2;
//			System.out.println(left + " - " + right + " - " + mid);
			if (check(candies, k, mid)) {
//				ans = mid;
				ans = Math.max(ans, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(maximumCandies(new int[] { 5, 8, 6 }, 3)); // 5
		System.out.println(maximumCandies(new int[] { 2, 5 }, 11)); // 0
		System.out.println(maximumCandies(new int[] { 4, 7, 5 }, 4)); // expected 3
		System.out.println(maximumCandies(new int[] { 1, 2, 3, 4, 10 }, 5)); // expected 3
		System.out.println(maximumCandies(new int[] { 750, 253, 391, 342, 151, 655, 934, 601, 870, 338, 866, 798, 806,
				795, 580, 225, 225, 961, 506, 536, 620, 486, 834, 757, 594, 657, 599, 859, 121, 854, 537, 903, 391, 555,
				983, 269, 898, 961, 109, 748, 832, 608, 659, 233, 608, 476, 564, 599, 989, 875, 229, 193, 725, 921, 836,
				534, 769, 277, 639, 628, 285, 563, 680, 839, 403, 689, 489, 979, 529, 868, 514, 795, 941, 464, 340, 700,
				997, 792, 422, 645, 745, 637, 908, 701, 597, 455, 135, 629, 981, 178, 551, 595, 993, 896, 700, 507, 997,
				884, 852, 928 }, 46)); // 659
//		System.out.println(maximumCandies(new int[] {}, 0));
	}

}
