/*
 * Example 1:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 1, c = 4
Output: 
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input: 
nums = 
[[1,2],
 [3,4]]
r = 2, c = 4
Output: 
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] matrixReshape(int[][] nums, int r, int c) {
		int or = nums.length;
		int oc = nums[0].length;
		if (or * oc < r * c)
			return nums;
		int[][] newMat = new int[r][c];
		int row = 0, col = 0;
		for (int i = 0; i < or; ++i) {
			for (int j = 0; j < oc; j++) {
				newMat[row][col] = nums[i][j];
				++col;
				if (col == c) {
					++row;
					col = 0;
				}
			}
		}
		return newMat;
	}
}
