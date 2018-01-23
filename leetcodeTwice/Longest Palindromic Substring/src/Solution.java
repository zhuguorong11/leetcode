/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestPalindrome(String s) {
		// 将窗口向右移动，可能是再原来的字符串上多加一个字符，也可能是在原来的字符串上+前一个字符和后一个字符
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		int currenLen = 0;
		String res = "";
		for (int i = 0; i < len; ++i) {
			if (isPalindrome(s, i - currenLen - 1, i)) {
				res = s.substring(i - currenLen - 1, i + 1);//在原来的字符串上+前一个字符和后一个字符
				currenLen += 2;
			} else if (isPalindrome(s, i - currenLen, i)) {//再原来的字符串上多加一个字符
				res = s.substring(i - currenLen, i + 1);
				currenLen += 1;
			}
		}
		return res;
	}

	public boolean isPalindrome(String s, int begin, int end) {
		if (begin < 0)
			return false;
		while (begin < end) {
			if (s.charAt(begin++) != s.charAt(end--))
				return false;
		}
		return true;
	}
}
