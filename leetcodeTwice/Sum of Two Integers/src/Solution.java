/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 * 
 * Example: Given a = 1 and b = 2, return 3.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.getSum(11, 2));
	}

	public static int getSum(int a, int b) {
		while(b != 0)
		{
			int temp = a;
			a = a ^ b;// 1 ^ 2 = 11, b may be is a carry
			b = (temp & b) << 1;
		}
		return a;
	}
}
