//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
		// ������¼��һ�к͵�һ�����Ƿ���0
		boolean firstRowZero = false, firstColZero = false;
		
		//�Ե�һ�� ��һ��Ϊ��׼
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;// �Ը�λ�������еĵ�һ�������
					matrix[i][0] = 0;// �Ը�λ�������еĵ�һ�������
					if (i == 0)
						firstRowZero = true;
					if (j == 0)
						firstColZero = true;
				}
			}
		}
		// ��ȥ��һ�к͵�һ�п�ʼ�������ж�
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0)
					matrix[i][j] = 0;
			}
		}

		// ����Ĳ����ѳ��˵�һ�к͵�һ�е��Ӿ�������˲���������ȥҪ�Ե�һ�к͵�һ�в���
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
