import java.util.ArrayList;
import java.util.List;

/*
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int rowEnd = matrix.length ;
		if (rowEnd == 0) {
			return res;
		}
		int colEnd = matrix[0].length ;
		// ����4������������λ�á�ĩλ�ã�����λ�á�ĩλ��
		int rowStart = 0,colStart = 0;
		rowEnd = rowEnd - 1;
		colEnd = colEnd - 1;
		while (rowStart <= rowEnd && colStart <= colEnd) {

			// ��������
			for (int i = colStart; i <= colEnd; i++) {
				res.add(matrix[rowStart][i]);
			}
			// ����һ��
			++rowStart;

			// ��������
			for (int i = rowStart; i <= rowEnd; i++) {
				res.add(matrix[i][colEnd]);
			}

			// ����һ��
			--colEnd;

			// ��������
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					res.add(matrix[rowEnd][i]);
				}
			}
			// ����һ��
			--rowEnd;

			// ��������
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					res.add(matrix[i][colStart]);
				}
			}
			// ����һ��
			++colStart;
		}
		return res;
	}
}
