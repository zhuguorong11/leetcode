import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a List of words, return the words that can be typed using letters of
 * alphabet on only one row's of American keyboard like the image below.
 * American keyboard
 * 
 * 
 * Example 1: 
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
	Output: ["Alaska", "Dad"]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findWords(String[] words) {
		String[] boards = new String[] { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < boards.length; ++i) {
			int strLen = boards[i].length();
			for (int j = 0; j < strLen; ++j) {
				char cc = boards[i].toUpperCase().charAt(j);
				map.put(cc, i);
			}
		}
		List<String> res = new ArrayList<>();
		for (String word : words) {
			char firstChar = word.toUpperCase().charAt(0);
			int firstIndex = map.get(firstChar);
			int len = word.length();
			boolean flag = true;
			for (int i = 1; i < len; ++i) {
				if (firstIndex != map.get(word.toUpperCase().charAt(i))) {
					flag = false;
					break;
				}
			}
			if (flag)
				res.add(word);
		}
		return res.toArray(new String[res.size()]);
	}
}
