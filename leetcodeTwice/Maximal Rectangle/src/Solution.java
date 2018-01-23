import java.util.Arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * For example, given the following matrix:
 * 
 * 1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 Return 6.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] left = new int[col];
		int[] right = new int[col];
		int[] height = new int[col];
		// initial
		Arrays.fill(left, 0);
		Arrays.fill(right, col);
		Arrays.fill(height, 0);
		int maxArea = 0;
		// use dp
		for (int i = 0; i < row; ++i) {
			int cur_left = 0, cur_right = col;
			// compute height of every row
			for (int j = 0; j < col; ++j) {
				if (matrix[i][j] == '1') {
					++height[j];
				} else
					height[j] = 0;
			}
			// compute left side
			for (int j = 0; j < col; ++j) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(cur_left, left[j]);
				} else {
					cur_left = j + 1;
					left[j] = 0;
				}
			}
			// compute right side
			for (int j = col - 1; j >= 0; --j) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(cur_right, right[j]);
				} else {
					cur_right = j;
					right[j] = col;
				}
			}
			// compute area
			for (int j = 0; j < col; ++j)
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
		}
		return maxArea;
	}
}
