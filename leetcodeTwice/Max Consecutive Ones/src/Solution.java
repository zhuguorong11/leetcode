/*
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.*/
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,1,0,1,1,1};
		System.out.println(Solution.findMaxConsecutiveOnes(nums));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int len = nums.length;
		if (len == 0 || nums == null)
			return 0;
		int max = 0;
		int cur = 0;
		for (int i = 0; i < len; ++i) {
			if (nums[i] == 1) {
				++cur;
			} else {
				max = Math.max(max, cur);
				cur = 0;
			}
		}
		max = Math.max(max, cur);
		return max;
	}
}
