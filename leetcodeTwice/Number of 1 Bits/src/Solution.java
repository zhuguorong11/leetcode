/**
 * Write a function that takes an unsigned integer and returns the number of ¡¯1'
 * bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ¡¯11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hammingWeight(int n) {
		if (n == 0)
			return 0;
		int count = 0;
		while (n != 0) {
			int bit = n & 1;
			if(bit == 1)
				++count;
			n = n >>> 1;
		}
		return count;
	}
}
