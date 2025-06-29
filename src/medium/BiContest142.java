package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dp[i][dest] = max(dp[i-1][curr] + travelScore[curr][dest], dp[i-1][dest] + stayScore[i][dest])

public class BiContest142 {

	public static int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
		int[] dp = new int[n];
		for (int i = 0; i < k; ++i) {
			int[] dp2 = dp.clone();
			for (int curr = 0; curr < n; ++curr)
				dp2[curr] += stayScore[i][curr];
			for (int curr = 0; curr < n; ++curr)
				for (int dest = 0; dest < n; ++dest)
					if (curr != dest)
						dp2[dest] = Math.max(dp2[dest], dp[curr] + travelScore[curr][dest]);
			dp = dp2;
		}
		return Arrays.stream(dp).max().getAsInt();
	}

	private static void printBoard(int[][] arr) {
		System.out.println(Arrays.deepToString(arr));
	}

	private static void printList(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public static int[] findSubtreeSizes(int[] parent, String s) {
		int n = parent.length;
		int[] answer = new int[n];
		answer[0] = n;
		int[] clonedParent = parent.clone();
		for (int node = 1; node < n; node++) {
			clonedParent = parent.clone();
			int ancestor = clonedParent[node];
			while (s.charAt(ancestor) != s.charAt(node) && clonedParent[ancestor] != -1)
				ancestor = clonedParent[ancestor];
			// System.out.println(ancestor + " - " + s.charAt(ancestor));
			if (s.charAt(ancestor) != s.charAt(node)) {
				// not found
				// do nothing
			} else {
				System.out.println(node + " - " + clonedParent[node] + " - " + ancestor + " - " + s.charAt(ancestor));
				clonedParent[node] = ancestor;
			}

			printList(clonedParent);

			int size = 1;
			for (int i = 1; i < n; i++) {
				if (clonedParent[i] == node && i != node)
					size++;
			}
			// System.out.println("+ " + node + "-" + size);
			answer[node] = size;
		}
		return answer;
	}

	// =============================================================

	// =============================================================

	public static void main(String[] args) {

		

//		var answer = findSubtreeSizes(new int[] { -1, 0, 0, 1, 1, 1 }, "abaabc");
//		printList(answer);

//		System.out.println(maxScore(2, 1, new int[][] { { 2, 3 } }, new int[][] { { 0, 2 }, { 1, 0 } }));
//		System.out.println(maxScore(3, 2, new int[][] { { 3, 4, 2 }, { 2, 1, 2 } },
//				new int[][] { { 0, 2, 1 }, { 2, 0, 4 }, { 3, 2, 0 } })); // expect 8
//		System.out.println(maxScore(2, 2, new int[][] { { 1, 3 }, { 4, 1 } }, new int[][] { { 0, 1 }, { 5, 0 } }));
//		System.out.println(maxScore(2, 1, new int[][] { { 2, 3 } }, new int[][] { { 0, 4 }, { 10, 0 } })); // expect 10
//
//		System.out.println(maxScore(2, 2, new int[][] { { 4, 2 }, { 1, 2 } }, new int[][] { { 0, 1 }, { 4, 0 } })); // expect
		// 6

		// System.out.println();
	}
}
