/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void solve(char[][] board) {
		/* use dfs */
		if (board == null) {
			return;
		}
		int row = board.length;
		if (row == 0) {
			return;
		}
		int col = board[0].length;

		/* at column edge */
		for (int i = 0; i < row; ++i) {
			if (board[i][0] == 'O') {
				merge(board, i, 0);
			}
			if (board[i][col - 1] == 'O') {
				merge(board, i, col - 1);
			}
		}
		for (int j = 0; j < col; ++j) {
			if (board[0][j] == 'O') {
				merge(board, 0, j);
			}
			if (board[row - 1][j] == 'O') {
				merge(board, row - 1, j);
			}
		}

		/*
		 * last change # to O and left O to X
		 */
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
			}
		}
	}

	/**make O in edge to # to avoid confuse */
	public void merge(char[][] board, int row, int col) {
		if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
			return;
		}
		if (board[row][col] != 'O') {
			return;
		}
		board[row][col] = '#';
		merge(board, row + 1, col);
		merge(board, row - 1, col);
		merge(board, row, col + 1);
		merge(board, row, col - 1);
	}
}
