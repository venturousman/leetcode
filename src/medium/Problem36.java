package medium;

public class Problem36 {
	// https://leetcode.com/problems/valid-sudoku/
	// sudoku

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					for (int c = 0; c < 9; c++) {
						if (c != j && board[i][c] == board[i][j])
							return false;
					}
					for (int r = 0; r < 9; r++) {
						if (r != i && board[r][j] == board[i][j])
							return false;
					}
					int sr = i / 3;
					sr *= 3;
					int sc = j / 3;
					sc *= 3;
					for (int r = sr; r < sr + 3; r++) {
						for (int c = sc; c < sc + 3; c++) {
							if (r != i && c != j && board[r][c] == board[i][j])
								return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
		System.out.println(isValidSudoku(new char[][] { { '8', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}

}
