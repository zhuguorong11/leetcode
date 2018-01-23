/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 *  the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
 *  it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount 
of money you can rob tonight without alerting the police.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rob(int[] nums) {
		int len = nums.length;
		if (len == 0 ) {
			return 0;
		}else if(len == 1)
			return nums[0];
		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for(int i = 2; i < len; ++i)
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		return dp[len - 1];
	}

	public int rob2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;

		int notRob = 0;// 指前一次没有rob
		int hasRob = 0;// 指一次rob

		for (int num : nums) {
			int temp = notRob + num;// 如果这一次抢劫，则说明上一家没抢劫，则+现在的值
			// if not rob ith house, take the max value of robbed (i-1)th house
			// and not rob (i-1)th house
			notRob = Math.max(notRob, hasRob);
			// 这一次抢劫后的值
			hasRob = temp;
		}
		return Math.max(hasRob, notRob);
	}

}
