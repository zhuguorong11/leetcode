/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note: Each of the array element will not exceed 100. The array size will not
 * exceed 200. Example 1:
 * 
 * Input: [1, 5, 11, 5]
 * 
 * Output: true
 * 
 * Explanation: The array can be partitioned as [1, 5, 5] and [11]. Example 2:
 * 
 * Input: [1, 2, 3, 5]
 * 
 * Output: false
 * 
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if ((sum & 1) == 1)
			return false;

		// 找到sum的一半值就好
		sum >>= 1;
		boolean[] dp = new boolean[sum + 1];
		dp[0] = true;// 空即值为0的集合，所以肯定存在
		for (int i = 0; i < nums.length; ++i) {
			for (int j = sum; j >= 0; --j) {
				if (j >= nums[i]) {
					dp[j] = dp[j] || dp[j - nums[i]];
				}
			}
		}
		return dp[sum];
	}
}
