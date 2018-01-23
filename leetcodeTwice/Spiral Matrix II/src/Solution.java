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
		// ����4������������λ�á�ĩλ�ã�����λ�á�ĩλ��
		int[][] matrix = new int[n][n];
		int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
		int k = 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {

			// ��������
			for (int i = colStart; i <= colEnd; i++) {
				matrix[rowStart][i] = k++;
			}
			// ����һ��
			++rowStart;

			// ��������
			for (int i = rowStart; i <= rowEnd; i++) {
				matrix[i][colEnd] = k++;
			}

			// ����һ��
			--colEnd;

			// ��������
			for (int i = colEnd; i >= colStart; i--) {
				matrix[rowEnd][i] = k++;
			}

			// ����һ��
			--rowEnd;

			// ��������
			for (int i = rowEnd; i >= rowStart; i--) {
				matrix[i][colStart] = k++;
			}

			// ����һ��
			++colStart;
		}
		return matrix;
	}
}
