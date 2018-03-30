/*
 * You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {
		/*
		 * 从行的角度看：
		 * 
		 * 原矩阵的第一行，变成了目标矩阵的最后一列。
		 * 
		 * 原矩阵的第二行，变成了目标矩阵的倒数第二列。
		 * 
		 * 原矩阵的第三行，变成了目标矩阵的倒数第三列。
		 * 
		 * 原矩阵的第四行，变成了目标矩阵的倒数第四列。
		 */
		int row = matrix.length;
		int col = row;
		int lastCol = col - 1;
		int[][] temp = new int[row][col];
		for (int i = 0; i < row; i++, lastCol--) {
			for (int j = 0; j < col; j++) {
				temp[j][lastCol] = matrix[i][j];
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = temp[i][j];
			}
		}
	}
	
	//不实用额外的空间， 可以先转置，然后对每一行进行反转
	public void rotate(int[][] matrix) {
		//转置
		for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
		for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
	}
}
