/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The
 * two words can be "ab", "cd".
 * 
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProduct(String[] words) {
		/* use bit operate */
		int len = words.length;
		int[] wordBit = new int[len];
		for (int i = 0; i < len; ++i) {
			String word = words[i];
			int wordLen = word.length();
			wordBit[i] = 0;
			for (int j = 0; j < wordLen; ++j) {
				wordBit[i] = wordBit[i] | (1 << (word.charAt(j) - 'a'));
			}
		}
		int resMax = 0;
		for (int i = 0; i < len - 1; ++i) {
			for (int j = i + 1; j < len; ++j) {
				/* no common letters */
				if ((wordBit[i] & wordBit[j]) == 0) {
					if (words[i].length() * words[j].length() > resMax){
						resMax = words[i].length() * words[j].length();
					}
				}
			}
		}
		return resMax;
	}
}
