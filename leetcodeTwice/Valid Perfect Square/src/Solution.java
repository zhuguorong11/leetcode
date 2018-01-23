/**
 * Given a positive integer num, write a function which returns True if num is a
 * perfect square else False.
 * 
 * Note: Do not use any built-in library function such as sqrt.
 * 
 * Example 1:
 * 
 * Input: 16 Returns: True Example 2:
 * 
 * Input: 14 Returns: False
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.isPerfectSquare(1));
	}

	public static boolean isPerfectSquare(int num) {
		int i = 1;
		while (num > 0) {
			num -= i;
			i = i + 2;
		}
		return num == 0;
	}
}
