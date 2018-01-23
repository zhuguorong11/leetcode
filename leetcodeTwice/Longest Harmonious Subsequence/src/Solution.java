import java.util.HashMap;
import java.util.Map;

/**
 * We define a harmonious array is an array where the difference between its
 * maximum value and its minimum value is exactly 1.
 * 
 * Now, given an integer array, you need to find the length of its longest
 * harmonious subsequence among all its possible subsequences.
 * 
 * Example 1: Input: [1,3,2,2,5,2,3,7] Output: 5 Explanation: The longest
 * harmonious subsequence is [3,2,2,2,3].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findLHS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		int max = 0;
		for (int key : map.keySet()) {
			if (map.containsKey(key + 1))
				max = Math.max(max, map.get(key) + map.get(key + 1));
		}
		return max;
	}
}
