/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 0, 3, 12 };
		Solution.moveZeroes(nums);
		for (int n : nums)
			System.out.print(n + " ");
	}

	public static void moveZeroes(int[] nums) {
		int len = nums.length ;
		int notZero = 0;
		for (int i = 0; i < len; ++i) {
			if (nums[i] != 0) {
				nums[notZero] = nums[i];
				++notZero;
			}
		}
		for (int i = len - 1; i >= notZero; --i) {
			nums[i] = 0;
		}
	}

}
