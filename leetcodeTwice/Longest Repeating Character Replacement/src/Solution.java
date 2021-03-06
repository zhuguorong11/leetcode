/**
 * Given a string that consists of only uppercase English letters, you can
 * replace any letter in the string with another letter at most k times. Find
 * the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa. Example 2:
 * 
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int characterReplacement(String s, int k) {
		int len = s.length();
		int start = 0;
		int j = 0;
		char[] table = new char[26];	
		int maxLen = 0;
		int maxCount = 0;//在一个窗口内，出现最多的字符
		while(j < len){
			maxCount = Math.max(maxCount, ++table[s.charAt(j) - 'A']);
			while(j - start + 1 - maxCount > k){
				--table[s.charAt(start++) - 'A'];
			}
			maxLen = Math.max(maxLen, j - start + 1);
			++j;
		}
		return maxLen;
	}
}
