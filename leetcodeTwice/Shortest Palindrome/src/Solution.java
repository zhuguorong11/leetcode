/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 * 
 * For example:
 * 
 * Given "aacecaaa", return "aaacecaaa".
 * 
 * Given "abcd", return "dcbabcd".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcd";
		System.out.println(Solution.shortestPalindrome(s));
	}

	public static String shortestPalindrome(String s) {
		int start = 0;
		for (int end = s.length() - 1; end >= 0; --end) {
			if (s.charAt(start) == s.charAt(end)) {
				++start;
			}
		}
		/* 说明本身就是个回文 */
		if (start == s.length()) {
			return s;
		}
		String suffix = s.substring(start);
		return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, start)) + suffix;
	}
}
