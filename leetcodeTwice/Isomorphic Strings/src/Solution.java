import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isIsomorphic(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		if (ss.length != tt.length)
			return false;
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < ss.length; ++i) {
			if (map.containsKey(ss[i])) {
				if (map.get(ss[i]) != tt[i])
					return false;
			} else {
				if (map.containsValue(tt[i]))
					return false;
				map.put(ss[i], tt[i]);
			}
		}
		return true;
	}
}
