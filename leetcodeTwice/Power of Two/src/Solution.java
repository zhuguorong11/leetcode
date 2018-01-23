/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		while(n != 1){
			int r = n % 2;
			if(r == 1)
				return false;
			n = n / 2;
		}
		return true;
	}
}
