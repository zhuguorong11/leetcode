/**
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * You may assume that there is only lower case English letters in both s and t.
 * t is potentially a very long (length ~= 500,000) string, and s is a short
 * string (<=100).
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Example 1: s = "abc", t = "ahbgdc"
 * 
 * Return true.
 * 
 * Example 2: s = "axc", t = "ahbgdc"
 * 
 * Return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSubsequence(String s, String t) {
		if (s == null || s.length() == 0)
			return true;
		int sEnd = s.length(), tEnd = t.length();
		int sIndex = 0, tIndex = 0;
		while (tIndex < tEnd) {
			if (s.charAt(sIndex) == t.charAt(tIndex)) {
				++sIndex;
				if (sIndex == sEnd)
					return true;
			}
			++tIndex;
		}
		return false;
	}
}
