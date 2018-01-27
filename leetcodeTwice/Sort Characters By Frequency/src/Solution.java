import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.frequencySort("tree"));
	}

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chs = s.toCharArray();
		int len = chs.length;
		for (char ch : chs)
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		List<Character>[] bucketsFre = new List[len + 1];
		for (char key : map.keySet()) {
			int fre = map.get(key);
			if (bucketsFre[fre] == null)
				bucketsFre[fre] = new ArrayList<>();
			bucketsFre[fre].add(key);
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int i = bucketsFre.length - 1; i >= 0; --i) {
			if (bucketsFre[i] != null) {
				for (char cc : bucketsFre[i]) {
					for (int j = 0; j < map.get(cc); ++j)
						sBuilder.append(cc);
				}
			}
		}
		return sBuilder.toString();
	}
}