import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * Example 1: Input: [0,1] Output: 2 Explanation: [0, 1] is the longest
 * contiguous subarray with equal number of 0 and 1. Example 2: Input: [0,1,0]
 * Output: 2 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray
 * with equal number of 0 and 1.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		// change 0 value to -1,that if there are equal 0 and 1,the sum is 0
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0)
				nums[i] = -1;
		}
		// sum as key, index of this sum as value
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, max = 0;
		map.put(0, -1);//initial
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				max = Math.max(max, i - map.get(sum));
			} else
				map.put(sum, i);
		}
		return max;
	}
}
