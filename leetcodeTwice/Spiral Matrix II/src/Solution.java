/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] generateMatrix(int n) {
		// 定义4个变量，行首位置、末位置，列首位置、末位置
		int[][] matrix = new int[n][n];
		int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
		int k = 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {

			// 从左往右
			for (int i = colStart; i <= colEnd; i++) {
				matrix[rowStart][i] = k++;
			}
			// 向下一层
			++rowStart;

			// 从上往下
			for (int i = rowStart; i <= rowEnd; i++) {
				matrix[i][colEnd] = k++;
			}

			// 向左一层
			--colEnd;

			// 从右往左
			for (int i = colEnd; i >= colStart; i--) {
				matrix[rowEnd][i] = k++;
			}

			// 向上一层
			--rowEnd;

			// 从下往上
			for (int i = rowEnd; i >= rowStart; i--) {
				matrix[i][colStart] = k++;
			}

			// 向右一层
			++colStart;
		}
		return matrix;
	}
}
