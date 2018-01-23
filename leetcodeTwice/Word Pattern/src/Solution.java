import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 * 
 * Examples: 
 * pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
		// use hashtable
		char[] chs = pattern.toCharArray();
		String[] strs = str.split(" ");
		if (chs.length != strs.length)
			return false;
		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < chs.length; ++i) {
			char cc = chs[i];
			if (map.containsKey(cc)) {
				if (!map.get(cc).equals(strs[i]))
					return false;
			} else {
				// if the map can't contain cc as the key, but contain the
				// strs[i] as the value of other key
				if (map.containsValue(strs[i]))
					return false;
				map.put(cc, strs[i]);
			}
		}
		return true;
	}
}
