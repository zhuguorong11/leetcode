/*
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has 
 * the maximum average value. And you need to output the maximum average value.

Example 1:
Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,1,3,3};
		System.out.println(Solution.findMaxAverage(nums, 4));
	}

	public static double findMaxAverage(int[] nums, int k) {
		int len = nums.length;
		int sum = 0;
		if (len < k) {
			for (int num : nums)
				sum += num;
			return sum *1.0/ len;
		}
		int start = 0, end = k - 1;
		for (int i = start; i <= end; ++i)
			sum += nums[i];
		double max = -Double.MAX_VALUE;
		double cur = sum * 1.0/ k;
		max = Math.max(max, cur);
		while (end < len - 1) {
			sum = sum - nums[start++] + nums[++end];
			cur = sum * 1.0/ k;
			max = Math.max(max, cur);			
		}
		return max;
	}
}
