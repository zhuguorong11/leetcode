/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}
		int begin = 0;
		int cur = 0;
		int end = nums.length - 1;
		while (cur <= end) {
			if (nums[cur] == 0) {
				swap(nums, begin, cur);
				++cur;
				++begin;
			} else if (nums[cur] == 1) {
				++cur;
			} else {
				swap(nums, end, cur);
				--end;
				/*why not need to --cur is that when after swap,nums[cur] == 0,
				 * then we shoud swap begin and cur in next round
				 * */
			}
		}
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
