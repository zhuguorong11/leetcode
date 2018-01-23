/**
 * Given an array of integers, every element appears twice except for one. Find
 * that single one.
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
		int[] nums = {1,1,2,2,3,3,5,5,4,6,6};
		System.out.println(Solution.singleNumber(nums));
	}

	public static int singleNumber(int[] nums) {
		int res = nums[0];
		for(int i = 1; i < nums.length; ++i){
			res = res ^ nums[i];
		}
		return res;
	}
}
