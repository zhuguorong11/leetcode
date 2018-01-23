/*
 * Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself 
a new place for his thievery so that he will not get too much attention. This time, 
all houses at this place are arranged in a circle. That means the first house is the 
neighbor of the last one. Meanwhile, the security system for these houses remain the 
same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 将题目1改成了一个环，可以两条支路，0-len-2 和 1 - len-1
	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0) {
			return 0;
		} else if (len == 1)
			return nums[0];
		return Math.max(doRob(nums, 0, len - 2), doRob(nums, 1, len - 1));
	}

	public int doRob(int[] nums, int start, int end) {
		int noRob = 0;
		int hasRob = 0;
		for (int i = start; i <= end; i++) {
			int temp = noRob + nums[i];

			noRob = Math.max(hasRob, noRob);
			hasRob = temp;
		}
		return Math.max(noRob, hasRob);
	}
}
