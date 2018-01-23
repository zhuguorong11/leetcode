/*
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
It doesn't matter what you leave beyond the new length.
 * */
public class Solution {
	public static void main(String[] strs) {

	}

	public int removeDuplicates(int[] nums) {
		int len = nums.length;
		if (len == 0 || nums == null)
			return 0;
		int count = 0;
		for (int num : nums) {
			if (count < 2 || num > nums[count - 2])
				nums[count++] = num;
		}
		return count;
	}
}
