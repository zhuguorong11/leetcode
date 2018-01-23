/**
 * Given a group of two strings, you need to find the longest uncommon
 * subsequence of this group of two strings. The longest uncommon subsequence is
 * defined as the longest subsequence of one of these strings and this
 * subsequence should not be any subsequence of the other strings. Input: "aba",
 * "cdc" Output: 3 Explanation: The longest uncommon subsequence is "aba" (or
 * "cdc"), because "aba" is a subsequence of "aba", but not a subsequence of any
 * other strings in the group of two strings.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLUSlength(String a, String b) {
		int len1 = a.length();
		int len2 = b.length();
		int max = Math.max(len1, len2);
		if (a.equals(b)) {
			return -1;
		} else
			return max;
	}
}
