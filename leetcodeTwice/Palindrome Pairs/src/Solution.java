import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in
 * the given list, so that the concatenation of the two words, i.e. words[i] +
 * words[j] is a palindrome.
 * 
 * Example 1: Given words = ["bat", "tab", "cat"] Return [[0, 1], [1, 0]] The
 * palindromes are ["battab", "tabbat"] Example 2: Given words = ["abcd",
 * "dcba", "lls", "s", "sssll"] Return [[0, 1], [1, 0], [3, 2], [2, 4]] The
 * palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (words == null || words.length == 0) {
			return res;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; ++i) {
			map.put(words[i], i);
		}
		for (int i = 0; i < words.length; ++i) {
			String word = words[i];
			for(int j = 0; j <= word.length(); ++j){
				String str1 = word.substring(0,j);
				String str2 = word.substring(j);
				//把剩余字符串的一个放在word的左边
				if(isPal(str1, 0, str1.length() - 1)){
					String str2reverse = new StringBuilder(str2).reverse().toString();
					if(map.containsKey(str2reverse) && i != map.get(str2reverse)){
						ArrayList<Integer> sub = new ArrayList<>();
						sub.add(map.get(str2reverse));
						sub.add(i);
						res.add(sub);
					}
				}
				//把剩余字符串的一个放在word的右边
				if(isPal(str2, 0, str2.length() - 1)){
					String str1reverse = new StringBuilder(str1).reverse().toString();
					if(map.containsKey(str1reverse) && i != map.get(str1reverse) && str2.length() != 0){
						ArrayList<Integer> sub = new ArrayList<>();
						sub.add(i);
						sub.add(map.get(str1reverse));
						res.add(sub);
					}
				}
			}
		}
		return res;
	}

	public boolean isPal(String s, int start, int end) {
		char[] chs = s.toCharArray();
		while (start < end) {
			if(chs[start] != chs[end]){
				return false;
			}
			++start;
			--end;
		}
		return true;
	}
}
