import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both
 * have a list of favorite restaurants represented by strings.
 * 
 * You need to help them find out their common interest with the least list
 * index sum. If there is a choice tie between answers, output all of them with
 * no order requirement. You could assume there always exists an answer.
 * 
 * Example 1: Input: ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * Output: ["Shogun"] Explanation: The only restaurant they both like is
 * "Shogun". Example 2: Input: ["Shogun", "Tapioca Express", "Burger King",
 * "KFC"] ["KFC", "Shogun", "Burger King"] Output: ["Shogun"] Explanation: The
 * restaurant they both like and have the least index sum is "Shogun" with index
 * sum 1 (0+1).
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String[] findRestaurant(String[] list1, String[] list2) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < list1.length; ++i) {
			map.put(list1[i], i);
		}
		List<String> res = new ArrayList<>();
		List<String> store = new ArrayList<>();
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < list2.length; ++i) {
			if (map.get(list2[i]) != null) {
				int curIndex = map.get(list2[i]) + i;
				map.put(list2[i], curIndex);
				minIndex = Math.min(minIndex, curIndex);
				store.add(list2[i]);
			}
		}
		for (String str : store) {
			if (map.get(str) == minIndex)
				res.add(str);
		}
		return res.toArray(new String[res.size()]);
	}
}
