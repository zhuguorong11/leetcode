/**
 * ]Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.isPalindrome(1232111111));
	}

	public static boolean isPalindrome(int x) {
		if (x < 0) 
			return false;
		int copyNum = x;		
		long newNum = 0;
		while (copyNum != 0) {
			int r = copyNum % 10;
			newNum =  newNum*10 + r;
			copyNum = copyNum / 10;
		}
//		System.out.println(x);
//		System.out.println(newNum);
		return x == newNum;
	}
}
