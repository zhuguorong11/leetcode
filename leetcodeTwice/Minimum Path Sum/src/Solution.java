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
					grid[i][j] = grid[0][0];// ��һ��λ��
				else if (i != 0 && j == 0)
					grid[i][j] = grid[i - 1][j] + grid[i][j];// ��һ���ϣ�ֻ����������
				else if (i == 0 && j != 0)
					grid[i][j] = grid[i][j - 1] + grid[i][j];// ��һ���ϣ�ֻ��������
				else {
					grid[i][j] = Math.min(grid[i - 1][j] , grid[i][j - 1]) + grid[i][j];// �����������£�Ҳ�����������ң�ȡ��С
				}
			}
		}
		return grid[row - 1][col - 1];
	}
}
