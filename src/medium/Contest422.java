package medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-i/description/
// dijkstra ?

public class Contest422 {

	static int[] dr2 = { -1, 0, 1, 0 };
	static int[] dc2 = { 0, 1, 0, -1 };
	// int[] dr = { -1, 0 };
	// int[] dc = { 0, -1 };
	static int[] dr = { 0, 1 };
	static int[] dc = { 1, 0 };
	static int min = Integer.MAX_VALUE;
	static int size = 50;
	static int factor = size + 1;

	// d[i][j] = min( d[i - 1][j], d[i][j - 1] ) + 1

	private static void dfs(int[][] moveTime, int n, int m, int r, int c, int[][] dp) {
		if (r == n - 1 && c == m - 1) {
			if (dp[n - 1][m - 1] < min)
				min = dp[n - 1][m - 1];
			return;
		}
		for (int i = 0; i < 2; i++) {
			int rr = r + dr[i];
			int cc = c + dc[i];
			boolean validR = rr >= 0 && rr < n;
			boolean validC = cc >= 0 && cc < m;
			if (validR && validC) {
				int max = Math.max(dp[r][c], moveTime[rr][cc]);
				dp[rr][cc] = max + 1;
				dfs(moveTime, n, m, rr, cc, dp);
			}
		}
	}

	private static int dijkstra(int[][] moveTime, int n, int m) {
		boolean[][] check = new boolean[n][m];
		int[][] dist = new int[n][m];
		Queue<Integer> queue = new LinkedList<>();
//		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		// start position
		int r = 0, c = 0;
		dist[r][c] = 0;
//		check[r][c] = true;
		int minDist = Integer.MAX_VALUE;

		int encoded = r * factor + c;
		queue.offer(encoded);
//		stack.push(encoded);

		while (!queue.isEmpty()) {
			int decoded = queue.poll();
//			int decoded = stack.pop();
			r = decoded / factor;
			c = decoded % factor;

			check[r][c] = true;

			for (int i = 0; i < 4; i++) {
				int rr = r + dr2[i];
				int cc = c + dc2[i];
				if (rr < 0 || cc < 0 || rr >= n || cc >= m)
					continue;
				if (check[rr][cc])
					continue;
				if (dist[r][c] != Integer.MAX_VALUE) {
					dist[rr][cc] = Math.max(dist[r][c], moveTime[rr][cc]) + 1;
					
					if (rr == n - 1 && cc == m - 1 && dist[rr][cc] < minDist)
						minDist = dist[rr][cc];
					
					queue.offer(rr * factor + cc);
//					stack.push(rr * factor + cc);
				}
			}

			System.out.println(Arrays.deepToString(dist));
		}

//		System.out.println(dist[n - 1][m - 1]);
//		System.out.println(Arrays.deepToString(dist));
//		return dist[n - 1][m - 1];
		return minDist;
	}

	public static int minTimeToReach(int[][] moveTime) {
		int n = moveTime.length;
		int m = moveTime[0].length; // no need to check input coz constraint >= 2
//		int[][] dp = new int[n][m];
//		dfs(moveTime, n, m, 0, 0, dp);
//		return min;
		return dijkstra(moveTime, n, m);
	}

	public static void main(String[] args) {
//		System.out.println(minTimeToReach(new int[][] { { 0, 4 }, { 4, 4 } })); // 6
//		System.out.println(minTimeToReach(new int[][] { { 0, 0, 0 }, { 0, 0, 0 } })); // 3
//		System.out.println(minTimeToReach(new int[][] { { 0, 1 }, { 1, 2 } })); // 3
//		System.out.println(minTimeToReach(new int[][] { { 27, 85 }, { 22, 53 } })); // 54
//		System.out.println(minTimeToReach(new int[][] { { 3, 72, 14 }, { 25, 81, 5 } })); // 75
//		System.out.println(minTimeToReach(new int[][] { { 56, 93 }, { 3, 38 } })); // 39
		System.out.println(minTimeToReach(new int[][] { { 94, 79, 62, 27, 69, 84 }, { 6, 32, 11, 82, 42, 30 } })); // 72		
	}
}
