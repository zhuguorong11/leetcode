/**
 * Given an array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int singleNumber(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int res = 0;
		for (int i = 0; i < 32; ++i) {
			int sum = 0;
			for (int j = 0; j < nums.length; ++j) {
				if (((nums[j] >> i) & 1) == 1) {
					sum++;
					sum %= 3;// 该位上出现3次的位数，出现三次的肯定能被整除
				}
			}
			if (sum != 0) {
				res |= 1 << i;
			}
		}
		return res;
	}
}
