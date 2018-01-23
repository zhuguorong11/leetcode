/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] singleNumber(int[] nums) {
		int diff = 0;
		for (int i = 0; i < nums.length; ++i)
			diff ^= nums[i];
		int index = 0;
		
		/*找到第一个两个数不同的位置*/
		for (index = 0; index < 32; index++) {
			if ((diff & (1 << index)) != 0)
				break;
		}
		diff = 1 << index;// different index 0 and 1
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((diff & nums[i]) == 0)
				res[0] ^= nums[i];
			else
				res[1] ^= nums[i];
		}
		return res;
	}
}
