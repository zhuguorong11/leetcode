/*
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] nums, int target) {
		int[] res = { -1, -1 };
		int len = nums.length;
		if (len == 0 || nums == null)
			return res;
		int left = 0;
		int right = len - 1;

		// 找左边位置
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target)
				left = mid + 1;
			else
				right = mid;
		}
		if (nums[left] != target) {
			return res;
		}else	
			res[0] = left;

		// 找右边位置
		right = len - 1;
		while (left < right) {
			int mid = left + (right - left) / 2 + 1;// 因为left已经确定，不能算在内，所以要+1
			if (nums[mid] > target) {
				right = mid - 1;
			} else
				left = mid;
		}
		res[1] = right;
		return res;
	}
}
