/*
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubArray(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return 0;
		int[] sumDP = new int[len];
		int max = nums[0];
		sumDP[0] = nums[0];
		for (int i = 1; i < len; ++i) {
			sumDP[i] = nums[i] + (sumDP[i - 1] > 0 ? sumDP[i - 1] : 0);
			max = Math.max(max, sumDP[i]);
		}
		return max;
	}
}
