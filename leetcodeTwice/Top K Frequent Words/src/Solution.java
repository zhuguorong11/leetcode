import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * 
 * Your answer should be sorted by frequency from highest to lowest. If two
 * words have the same frequency, then the word with the lower alphabetical
 * order comes first.
 * 
 * Example 1: Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"] Explanation: "i" and "love" are the two most frequent
 * words. Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2: Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny",
 * "is", "is"], k = 4 Output: ["the", "is", "sunny", "day"] Explanation: "the",
 * "is", "sunny" and "day" are the four most frequent words, with the number of
 * occurrence being 4, 3, 2 and 1 respectively. Note:
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* 0(n)time and space */
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new TreeMap<>();
		List<String>[] buckets = new ArrayList[words.length + 1];
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (String key : map.keySet()) {
			int freq = map.get(key);
			if (buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}
		List<String> res = new ArrayList<>();
		for (int i = words.length; i >= 0 && res.size() < k; --i) {
			if (buckets[i] != null) {
				res.addAll(buckets[i]);
			}
		}
		while(res.size() > k){
			res.remove(res.size() - 1);
		}
		return res;
	}
}
