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
		 * ���еĽǶȿ���
		 * 
		 * ԭ����ĵ�һ�У������Ŀ���������һ�С�
		 * 
		 * ԭ����ĵڶ��У������Ŀ�����ĵ����ڶ��С�
		 * 
		 * ԭ����ĵ����У������Ŀ�����ĵ��������С�
		 * 
		 * ԭ����ĵ����У������Ŀ�����ĵ��������С�
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
	
	//��ʵ�ö���Ŀռ䣬 ������ת�ã�Ȼ���ÿһ�н��з�ת
	public void rotate(int[][] matrix) {
		//ת��
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
