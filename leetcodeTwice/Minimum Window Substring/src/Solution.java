/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * For example, S = "ADOBECODEBANC" T = "ABC" Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return
 * the empty string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always
 * be only one unique minimum window in S.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
		if (s == null || s.isEmpty() || t == null || t.isEmpty()) {
			return "";
		}
		int lens = s.length();
		int lent = t.length();
		int[] smap = new int[256];
		int[] tmap = new int[256];
		for (char ch : t.toCharArray())
			++tmap[ch];
		int i = 0, j = 0;
		int foundChar = 0;
		int resLen = Integer.MAX_VALUE;
		String res = "";
		while (j < lens) {
			if (foundChar < lent) {
				if (tmap[s.charAt(j)] > 0) {
					++smap[s.charAt(j)];
					if (smap[s.charAt(j)] <= tmap[s.charAt(j)])
						++foundChar;
				}
				++j;
			}
			while (foundChar == lent) {
				if (j - i < resLen) {
					resLen = j - i;
					res = s.substring(i, j);
				}
				if (tmap[s.charAt(i)] > 0) {
					--smap[s.charAt(i)];
					if (smap[s.charAt(i)] < tmap[s.charAt(i)])
						--foundChar;
				}
				++i;
			}
		}
		return res;
	}
}
