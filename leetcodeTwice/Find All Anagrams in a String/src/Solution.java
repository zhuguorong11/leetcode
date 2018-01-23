import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findAnagrams(String s, String p) {
		// window sliding,the size of it is length of p
		
		List<Integer> res = new ArrayList<>();
		int lens = s.length();
		int lenp = p.length();
		if(lens < lenp)
			return res;
		int[] words = new int[26];
		int[] wordp = new int[26];
		for (int i = 0; i < lenp; ++i) {
			++wordp[p.charAt(i) - 'a'];
		}
		for (int i = 0; i < lenp; ++i) {
			++words[s.charAt(i) - 'a'];
		}
		for (int i = 0; i < lens; ++i) {
			if (isSameValue(wordp, words))
				res.add(i);
			if((i + lenp) < lens)
			{
				// slide window
				--words[s.charAt(i) - 'a'];
				++words[s.charAt(i + lenp) - 'a'];
			}
			else
				break;
		}
		return res;
	}

	// compare two int array,to judge wheter they have the same values
	public boolean isSameValue(int[] p, int[] q) {
		int len = p.length;
		for (int i = 0; i < len; i++) {
			if (p[i] != q[i])
				return false;
		}
		return true;
	}
}
