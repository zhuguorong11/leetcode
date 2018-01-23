/**
 * 给定 n 个不同的正整数，整数 k（k < = n）以及一个目标数字。在这 n 个数里面找出 k 个数，使得这 k 个数的和等于目标数字，写一个函数实现找到不同的方案的数量
 */
package kth_sum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,2,3,4,6};
		System.out.println(Solution.kth(nums, 2, 5));
	}

	public static int kth(int[] nums, int k, int target) {

		// dp[k][target]表示k个数前，满足和为target的方案数量
		int[][] dp = new int[k + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= nums.length; ++i) {
			for (int j = k; j >= 1; --j) {
				for (int s = target; s >= nums[i - 1]; --s) {
					dp[j][s] += dp[j - 1][s - nums[i - 1]];
				}
			}
		}
		return dp[k][target];
	}
}
