/*
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[] nums, int k) {
		int len = nums.length;
		k = k % len;
		reverse(nums, 0, len - 1);// 先将整个数组旋转
		reverse(nums, 0, k - 1);
		reverse(nums, k, len - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			++start;
			--end;
		}
	}

	public void rotate2(int[] nums, int k) {
		int len = nums.length;
		int[] tmp = new int[len];
		for (int i = 0; i < len; ++i)
			tmp[i] = nums[i];
		for (int i = 0; i < len; ++i) {
			nums[(i + k) % len] = tmp[i];
		}
	}
}
