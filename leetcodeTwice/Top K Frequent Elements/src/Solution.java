import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ¡Ü k ¡Ü number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer>[] buckets = new List[nums.length + 1];
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		// use frequence as index of res,and key as value of res
		for (int key : map.keySet()) {
			int frequence = map.get(key);
			if (buckets[frequence] == null)
				buckets[frequence] = new ArrayList<>();
			buckets[frequence].add(key);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = buckets.length - 1; i >= 0 && res.size() < k; --i) {
			if (buckets[i] != null)
				res.addAll(buckets[i]);
		}
		return res;
	}
}
