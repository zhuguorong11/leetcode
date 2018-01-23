/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.


 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ����һ�����������
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target)
				return true;
			else if (matrix[row][col] > target) {
				--col;
			} else {
				++row;
			}
		}
		return false;
	}

	public boolean aaa(int[][] matrix, int target) {
		if (matrix.length == 0)
			return false;
		int row = matrix.length;
		int col = matrix[0].length;
		int start = 0;
		int end = row * col - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int num = matrix[mid / col][mid % col];
			if (num == target) {
				return true;
			} else if (num > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
}
