/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "abcdefg";
		String s2 = "efg";
		System.out.println(Solution.strStr(s1, s2));
	}

	public static int strStr(String haystack, String needle) {
		int len1 = haystack.length();
		int len2 = needle.length();
		if (len1 < len2) {
			return -1;
		}
		for (int i = 0; i <= len1 - len2; ++i) {
			if (haystack.substring(i, i + len2).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
