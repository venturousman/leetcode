package medium;

import java.lang.Math;
/*
 * Constraints:
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 106
 */

public class Problem2684 {

	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };

	private static int dfs(int[][] grid, int rows, int cols, int r, int c) {
		if (c == cols - 1)
			return 0;

		int moves = 0;
		for (int i = 0; i < 3; i++) {
			int newR = r + dr[i];
			int newC = c + dc[i];
			boolean isValidR = (newR >= 0 && newR < rows);
			boolean isValidC = (newC >= 0 && newC < cols);
			if (isValidR && isValidC && grid[newR][newC] > grid[r][c]) {
				moves = Math.max(moves, 1 + dfs(grid, rows, cols, newR, newC));
			}
		}
		return moves;
	}

	public static int maxMoves(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int max = 0;
		for (int r = 0; r < rows; r++) {
			max = Math.max(max, dfs(grid, rows, cols, r, 0));
		}
		return max;
	}

	public static void main(String[] args) {
		System.out
				.println(maxMoves(new int[][] { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } }));
		System.out.println(maxMoves(new int[][] { { 3, 2, 4 }, { 2, 1, 9 }, { 1, 1, 7 } }));
//		System.out.println();
//		System.out.println();
	}

}
