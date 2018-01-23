/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 10, 1,9, 2, 5, 3, 7, 101, 102, 105, 106,18 };
		System.out.println(Solution.lengthOfLIS(nums));
	}

	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		int[] dp = new int[len];
		int maxLIS = 0;
		for (int i = 0; i < len; ++i) {
			dp[i] = 1;// 每一个数自己都是一个序列，长度为1
		}
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
					dp[i] = dp[j] + 1;
			}
		}
		for (int i = 0; i < len; ++i) {
			if (maxLIS < dp[i])
				maxLIS = dp[i];
		}
		return maxLIS;
	}
}
