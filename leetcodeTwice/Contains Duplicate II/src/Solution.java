import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers and an integer k, find out whether there are two distinct 
 * indices i and j in the array such that nums[i] = nums[j] and the absolute difference 
 * between i and j is at most k.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		int len = nums.length;
		if (len == 0 || nums == null || k < 1)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < len; ++i) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k)
					return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}
}
