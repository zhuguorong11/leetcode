/*
 * Given an array of n integers where n > 1, nums, return an array output such that output[i] 
 * is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does 
not count as extra space for the purpose of space complexity analysis.)
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		// 先从左向右乘，每一位对前几位数进行累乘保存到res中
		res[0] = 1;
		for (int i = 1; i < len; ++i) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		//从右向左，每一位对后几位进行累乘。
		for (int i = len - 1; i >= 0; --i) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;
	}
}
