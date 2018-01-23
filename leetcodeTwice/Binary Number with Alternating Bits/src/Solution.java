/**
 * Given a positive integer, check whether it has alternating bits: namely, if
 * two adjacent bits will always have different values.
 * 
 * Example 1: Input: 5 Output: True Explanation: The binary representation of 5
 * is: 101 Example 2: Input: 7 Output: False Explanation: The binary
 * representation of 7 is: 111. Example 3: Input: 11 Output: False Explanation:
 * The binary representation of 11 is: 1011. Example 4: Input: 10 Output: True
 * Explanation: The binary representation of 10 is: 1010.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		System.out.println(Solution.hasAlternatingBits(n));
	}

	public static boolean hasAlternatingBits(int n) {
		if (n == 0)
			return false;
		int preBit = n & 1;
		int curBit = 0;
		n = n >>> 1;
		while (n != 0) {
			curBit = n & 1;
			if (preBit == curBit)
				return false;
			n = n >>> 1;
			preBit = curBit;
		}
		return true;
	}
}
