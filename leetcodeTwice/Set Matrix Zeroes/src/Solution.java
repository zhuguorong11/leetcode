//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		// 用来记录第一行和第一列中是否有0
		boolean firstRowZero = false, firstColZero = false;
		
		//以第一行 第一列为基准
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;// 以该位置所在列的第一行做标记
					matrix[i][0] = 0;// 以该位置所在行的第一列做标记
					if (i == 0)
						firstRowZero = true;
					if (j == 0)
						firstColZero = true;
				}
			}
		}
		// 出去第一行和第一列开始遍历，判断
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}

		// 上面的操作把除了第一行和第一列的子矩阵进行了操作，接下去要对第一行和第一列操作
		if (firstRowZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		if (firstColZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}
}
