/**
 * In a given integer array nums, there is always exactly one largest element.
 * 
 * Find whether the largest element in the array is at least twice as much as
 * every other number in the array.
 * 
 * If it is, return the index of the largest element, otherwise return -1.
 * 
 * Example 1:
 * 
 * Input: nums = [3, 6, 1, 0] Output: 1 Explanation: 6 is the largest integer,
 * and for every other number in the array x, 6 is more than twice as big as x.
 * The index of value 6 is 1, so we return 1.
 * 
 * 
 * Example 2:
 * 
 * Input: nums = [1, 2, 3, 4] Output: -1 Explanation: 4 isn't at least as big as
 * twice the value of 3, so we return -1.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(Solution.dominantIndex(nums));
	}

	public static int dominantIndex(int[] nums) {
		int max = nums[0];
		int secondMax = Integer.MIN_VALUE;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		for (int num : nums) {
			if (num != max) {
				secondMax = Math.max(secondMax, num);
			} else {
				continue;
			}
		}
		int index = 0;
		for (int i = 0; i < nums.length; ++i) {
			if (max == nums[i]) {
				index = i;
				break;
			}
		}
		if (max >= (2 * secondMax)) {
			return index;
		} else {
			return -1;
		}
	}
}
