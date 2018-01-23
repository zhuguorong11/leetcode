import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a magic directory with buildDict, and search methods.
 * 
 * For the method buildDict, you'll be given a list of non-repetitive words to
 * build a dictionary.
 * 
 * For the method search, you'll be given a word, and judge whether if you
 * modify exactly one character into another character in this word, the
 * modified word is in the dictionary you just built.
 * 
 * Example 1: Input: buildDict(["hello", "leetcode"]), Output: Null Input:
 * search("hello"), Output: False Input: search("hhllo"), Output: True Input:
 * search("hell"), Output: False Input: search("leetcoded"), Output: False Note:
 * You may assume that all the inputs are consist of lowercase letters a-z. For
 * contest purpose, the test data is rather small by now. You could think about
 * highly efficient algorithm after the contest. Please remember to RESET your
 * class variables declared in class MagicDictionary, as static/class variables
 * are persisted across multiple test cases. Please see here for more details.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
class MagicDictionary {
	// cut one character as key,
	// like{"ello":[[0,'h']],"hllo":[[1,'e']],"helo":[[2,'l],[3,'l']]}....
	Map<String, List<int[]>> map;

	/** Initialize your data structure here. */
	public MagicDictionary() {
		map = new HashMap<>();
	}
	/** Build a dictionary through a list of words */
	public void buildDict(String[] dict) {
		for (String string : dict) {
			for (int i = 0; i < string.length(); ++i) {
				String key = string.substring(0, i) + string.substring(i + 1);// as
																				// key
				int[] pair = new int[] { i, string.charAt(i) };
				List<int[]> value = map.getOrDefault(key, new ArrayList<>());
				value.add(pair);
				map.put(key, value);
			}
		}
	}
	/**
	 * Returns if there is any word in the trie that equals to the given word
	 * after modifying exactly one character
	 */
	public boolean search(String word) {
		for (int i = 0; i < word.length(); ++i) {
			String key = word.substring(0, i) + word.substring(i + 1);
			if (map.containsKey(key)) {
				for (int[] pair : map.get(key)) {
					if (pair[0] == i && word.charAt(i) != pair[1])
						return true;
				}
			}
		}
		return false;
	}
}