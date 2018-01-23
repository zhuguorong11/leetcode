/*
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		System.out.println(Solution.findUnsortedSubarray(nums));
	}

	public static int findUnsortedSubarray(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;

		// 通过2个指针进行从左往右 和从右往左的遍历
		int start = -1;
		int end = -2;
		int max = nums[0];
		int min = nums[len - 1];
		for (int i = 0; i < len; ++i) {
			//从左向右
			max = Math.max(max,nums[i]);
			//从右向左
			min = Math.min(min, nums[len - i - 1]);
			if(nums[i] < max)
				end = i;
			if(nums[len - i - 1] > min)
				start = len - i - 1;
		}
		return end - start + 1;
	}
}
