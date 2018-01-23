/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rangeBitwiseAnd(int m, int n) {
		int diff = 1;
		while(m != n){
			m >>= 1;
			n >>= 1;
			diff <<= 1;
		}
		return m * diff;
	}
}
