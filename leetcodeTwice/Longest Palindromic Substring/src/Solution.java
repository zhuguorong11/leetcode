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
		// �����������ƶ�����������ԭ�����ַ����϶��һ���ַ���Ҳ��������ԭ�����ַ�����+ǰһ���ַ��ͺ�һ���ַ�
		if (s == null || s.length() == 0) {
			return "";
		}
		int len = s.length();
		int currenLen = 0;
		String res = "";
		for (int i = 0; i < len; ++i) {
			if (isPalindrome(s, i - currenLen - 1, i)) {
				res = s.substring(i - currenLen - 1, i + 1);//��ԭ�����ַ�����+ǰһ���ַ��ͺ�һ���ַ�
				currenLen += 2;
			} else if (isPalindrome(s, i - currenLen, i)) {//��ԭ�����ַ����϶��һ���ַ�
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
