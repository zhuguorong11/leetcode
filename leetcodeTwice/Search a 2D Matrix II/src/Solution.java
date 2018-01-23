/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17,
 * 24], [18, 21, 23, 26, 30] ] Given target = 5, return true.
 * 
 * Given target = 20, return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrix(int[][] matrix, int target) {
		// start from right-top
		int row = matrix.length;
		if(row == 0)
			return false;
		int i = 0;
		int j = matrix[0].length - 1;
		while (i < row && j >= 0) {
			if (target == matrix[i][j])
				return true;
			if (target < matrix[i][j])
				--j;
			else
				++i;
		}
		return false;
	}
}
