import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Given a list of strings words representing an English Dictionary, find the
 * longest word in words that can be built one character at a time by other
 * words in words. If there is more than one possible answer, return the longest
 * word with the smallest lexicographical order.
 * 
 * If there is no answer, return the empty string. Example 1: Input: words =
 * ["w","wo","wor","worl", "world"] Output: "world" Explanation: The word
 * "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Example 2: Input: words = ["a", "banana", "app", "appl", "ap", "apply",
 * "apple"] Output: "apple" Explanation: Both "apply" and "apple" can be built
 * from other words in the dictionary. However, "apple" is lexicographically
 * smaller t
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public String longestWord(String[] words) {
		/*use hasetable to store previous string*/
		String res = "";
		Set<String> set = new HashSet<>();
		if (words == null || words.length == 0) {
			return res;
		}
		Arrays.sort(words);
		for (String word : words) {
			int len = word.length();
//			if(len == 1){
//				res = len > res.length() ? word : res;
//				set.add(word);
//				continue;
//			}
			if (len == 1 || set.contains(word.substring(0, len - 1))) {
				res = len > res.length() ? word : res;
				set.add(word);
			}
		}
		return res;
	}
}
