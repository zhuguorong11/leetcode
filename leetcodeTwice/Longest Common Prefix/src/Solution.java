/**
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int len = strs.length;
		// ≥ı ºªØprefix
		String prefix = strs[0];
		for (int i = 1; i < len; i++) {
			if (strs[i].equals(prefix)) {
				continue;
			}
			int k = 0;
			while (k < strs[i].length() && k < prefix.length() && strs[i].charAt(k) == prefix.charAt(k))
				++k;
			prefix = strs[i].substring(0, k);
		}
		return prefix;
	}
}
