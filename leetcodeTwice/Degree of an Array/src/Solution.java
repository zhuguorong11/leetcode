import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this
 * array is defined as the maximum frequency of any one of its elements.
 * 
 * Your task is to find the smallest possible length of a (contiguous) subarray
 * of nums, that has the same degree as nums.
 * 
 * Example 1: Input: [1, 2, 2, 3, 1] Output: 2 Explanation: The input array has
 * a degree of 2 because both elements 1 and 2 appear twice. Of the subarrays
 * that have the same degree: [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1,
 * 2, 2], [2, 2, 3], [2, 2] The shortest length is 2. So return 2. 
 * Example 2:
 * Input: [1,2,2,3,1,4,2] Output: 6
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,1,4,2};
		System.out.println(Solution.findShortestSubArray(nums));
	}

	public static int findShortestSubArray(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer[]> getRange = new HashMap<>();
		Map<Integer, Integer> getFreq = new HashMap<>();
		int maxDegree = Integer.MIN_VALUE;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			getFreq.put(nums[i], getFreq.getOrDefault(nums[i], 0) + 1);
			maxDegree = Math.max(maxDegree, getFreq.get(nums[i]));

			if (getRange.get(nums[i]) == null) {
				getRange.put(nums[i], new Integer[2]);
			}
			Integer[] range = getRange.get(nums[i]);
			if (range[0] == null) {
				range[0] = i;
			}
			range[1] = i;
//			getRange.put(nums[i],range);
		}
		/* ���� */
//		for (Entry<Integer, Integer> entry : getFreq.entrySet()) {
//			if (entry.getValue() != maxDegree) {
//				continue;
//			}
//			Integer[] range = getRange.get(entry.getKey());
//			res = Math.min(res, range[1] - range[0] + 1);
//		}
		Iterator<Integer> iterator = getFreq.keySet().iterator();
		while(iterator.hasNext()){
			int key = iterator.next();
			int value = getFreq.get(key);
			if (value != maxDegree) {
				continue;
			}
			Integer[] range = getRange.get(key);
			res = Math.min(res, range[1] - range[0] + 1);
		}
		return res;
	}
}
