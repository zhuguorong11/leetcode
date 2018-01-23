//Divide two integers without using multiplication, division and mod operator.

//If it is overflow, return MAX_INT.
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.divide(-2147483648,-1));
	}

	public static int divide(int dividend, int divisor) {
		long a = dividend, b = divisor;
		boolean flag = false;
		if (a > 0 && b < 0 || a < 0 && b > 0)
			flag = true;// ¸ººÅ

		a = Math.abs(a);
		b = Math.abs(b);
		long c = b;
		long mut = 1;
		long res = 0;
		while (a > 0) {
			if (a >= c) {
				res += mut;
				a -= c;
				mut <<= 1;
				c <<= 1;
			} else {
				mut >>= 1;
				c >>= 1;
			}
		}
		System.out.println(res);
		if (flag) {
			return -res < Integer.MIN_VALUE ? Integer.MIN_VALUE : -(int) res;
		} else
			return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
	}
}
