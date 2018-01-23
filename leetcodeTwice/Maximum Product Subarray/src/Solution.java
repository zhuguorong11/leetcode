/*
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,-2,4};
		System.out.println(Solution.maxProduct(nums));
	}

	@SuppressWarnings("null")
	public static int maxProduct(int[] nums) {
		// 因为是乘法，所以要考虑负数*负数的情况
		int len = nums.length;
		if (len == 0 || nums == null)
			return (Integer) null;

		int res = nums[0], maxValue = nums[0], minValue = nums[0];
		for (int i = 1; i < len; ++i) {
			int temp = maxValue;
			maxValue = Math.max(Math.max(maxValue * nums[i], minValue * nums[i]), nums[i]);
			minValue = Math.min(Math.min(temp * nums[i], minValue * nums[i]), nums[i]);
			if (res < maxValue)
				res = maxValue;
		}
		return res;
	}
}
