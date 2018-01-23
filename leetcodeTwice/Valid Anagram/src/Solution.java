/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isAnagram(String s, String t) {
		int[] ss = new int[26];
		int[] tt = new int[26];
		int lens = s.length();
		int lent = t.length();
		for (int i = 0; i < lens; ++i)
			++ss[s.charAt(i) - 'a'];
		for (int i = 0; i < lent; ++i)
			++tt[t.charAt(i) - 'a'];
		int i;
		for (i = 0; i < 26; ++i) {
			if (tt[i] - ss[i] != 0)
				return false;
		}
		return true;
	}
}
