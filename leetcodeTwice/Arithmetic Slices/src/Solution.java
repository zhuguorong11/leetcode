/*
 * A sequence of number is called arithmetic if it consists of at least three elements 
 * and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of 
integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfArithmeticSlices(int[] A) {
		int len = A.length;
		if (len < 3) {
			return 0;
		}
		int res = 0;
		int curTotal = 0;// 该连续模式下，当前的个数
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				//此时，当前趋势下个数+1
				++curTotal;
				//此时肯定也包含前面出现的位数，比如1，2，3，4，到遍历到4的时候得到2，3，4满足，而1，2，3，4也满足
				res += curTotal;
			} else
				curTotal = 0;
		}
		return res;
	}
}
