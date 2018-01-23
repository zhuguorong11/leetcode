/**
 * Given a string, your task is to count how many palindromic substrings in this
 * string.
 * 
 * The substrings with different start indexes or end indexes are counted as
 * different substrings even they consist of same characters.
 * 
 * Example 1: Input: "abc" Output: 3 Explanation: Three palindromic strings:
 * "a", "b", "c". 
 * Example 2: Input: "aaa" Output: 6 Explanation: Six palindromic
 * strings: "a", "a", "a", "aa", "aa", "aaa
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(Solution.countSubstrings("abc"));
	}

	//相当于是暴力算法了，时间长
	public int countSubstrings(String s) {
		int res = 0;
		if (s == null || s.length() == 0)
			return res;
		int len = s.length();
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j <= len; ++j) {
				String ss = s.substring(i, j);
				if (isPalindrome(ss)) {
					++res;
				}
			}
		}
		return res;
	}
	public boolean isPalindrome(String s) {
		int begin = 0, end = s.length() - 1;
		while (begin < end) {
			if (s.charAt(begin++) != s.charAt(end--))
				return false;
		}
		return true;
	}
	
	//*************************另外一种解法，时间更短
	public int countSubstrings2(String s) {
		int res = 0;
		if (s == null || s.length() == 0)
			return res;
		int len = s.length();
		for (int i = 0; i < len; ++i) {
			res += extendPal(s, i, i) + extendPal(s, i, i + 1);//跟longest Palindromic substring类似
		}
		return res;
	}

	public int extendPal(String s, int left, int right) {
		int count = 0;
		while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
			++count;
		return count;
	}
}
