/*
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,2,3};
		System.out.println(Solution.removeElement(nums, 3));
	}

	public static int removeElement(int[] nums, int val) {
		int len = nums.length;
		if(len == 0 || nums == null)
			return 0;
		int count = 0;
		for(int num: nums)
		{
			if(num != val)
			{
				nums[count++] = num;
			}
		}
		return count;
	}
}
