import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a string and a string dictionary, find the longest string in the
 * dictionary that can be formed by deleting some characters of the given
 * string. If there are more than one possible results, return the longest word
 * with the smallest lexicographical order. If there is no possible result,
 * return the empty string.
 * 
 * Example 1: Input: s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * 
 * Output: "apple" Example 2: Input: s = "abpcplea", d = ["a","b","c"]
 * 
 * Output: "a"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String findLongestWord(String s, List<String> d) {
		//longest so first sort by desc
		Collections.sort(d,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.length() == o2.length() ? o1.compareTo(o2) : -Integer.compare(o1.length(), o2.length());
			}
		});
		for(String word : d){
			int count = 0;
			for(char ch : s.toCharArray()){
				if(word.charAt(count) == ch){
					++count;
				}
				if(count == word.length())
				{
					return word;
				}
			}
		}
		return "";
	}
}
