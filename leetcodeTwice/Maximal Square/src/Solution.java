/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0 
 * 1 0 1 1 1 
 * 1 1 1 1 1 
 * 1 0 0 1 0 
 * Return 4.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximalSquare(char[][] matrix) {
		int row = matrix.length;
		if (row == 0) {
			return 0;
		}
		int res = 0;//边长
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i <= row; ++i) {
			for (int j = 1; j <= col; ++j) {
				if (matrix[i - 1][j - 1] == '1') {
					// 由top left ， left 和 top决定正方形边长,取最小值
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res * res;
	}
}
