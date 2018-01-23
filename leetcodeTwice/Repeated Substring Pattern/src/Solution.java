/**
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000. Example 1: Input: "abab"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "ab" twice. Example 2: Input: "aba"
 * 
 * Output: False Example 3: Input: "abcabcabcabc"
 * 
 * Output: True
 * 
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc"
 * twice.)
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "aba";
		System.out.println(Solution.repeatedSubstringPattern(string));
	}

	public static boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int len = s.length();
		for (int i = len / 2; i >= 1; --i) {
			if (len % i == 0) {
				int numPart = len / i;
				String sub = s.substring(0, i);// ÖØ¸´µÄÆ¬¶Î
				StringBuilder sBuilder = new StringBuilder();
				for (int j = 0; j < numPart; ++j) {
					sBuilder.append(sub);
				}
				if (sBuilder.toString().equals(s)) {
					return true;
				}
			}
		}
		return false;
	}
}
