import java.util.Arrays;

/*
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int triangleNumber(int[] nums) {
		int len = nums.length;
		if (len <= 2)
			return 0;
		Arrays.sort(nums);
		int res = 0;
		for (int i = 2; i < len; ++i) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				if (nums[left] + nums[right] > nums[i]) {
					res += (right - left);
					--right;
				} else
					++left;
			}
		}
		return res;
	}
}
