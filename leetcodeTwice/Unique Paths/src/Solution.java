/*
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == 0 || j == 0) // 第一行和第一列上的的格子均只能来自一个方向 所以初始化为1
					matrix[i][j] = 1;
				else
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
			}
		}
		return matrix[m - 1][n - 1];
	}
}
