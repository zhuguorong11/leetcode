/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to 
 * bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
		int row = grid.length;
		if (row == 0)
			return 0;
		int col = grid[0].length;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0)
					grid[i][j] = grid[0][0];// 第一个位置
				else if (i != 0 && j == 0)
					grid[i][j] = grid[i - 1][j] + grid[i][j];// 第一列上，只能由上往下
				else if (i == 0 && j != 0)
					grid[i][j] = grid[i][j - 1] + grid[i][j];// 第一行上，只能由左往
				else {
					grid[i][j] = Math.min(grid[i - 1][j] , grid[i][j - 1]) + grid[i][j];// 可以右上往下，也可以由左往右，取最小
				}
			}
		}
		return grid[row - 1][col - 1];
	}
}
