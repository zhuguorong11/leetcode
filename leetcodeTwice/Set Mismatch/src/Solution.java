/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to
 * the data error, one of the numbers in the set got duplicated to another
 * number in the set, which results in repetition of one number and loss of
 * another number.
 * 
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number
 * that is missing. Return them in the form of an array.
 * 
 * Example 1: Input: nums = [1,2,2,4] Output: [2,3]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findErrorNums(int[] nums) {
		int[] count = new int[nums.length + 1];
		for (int num : nums) {
			++count[num];
		}
		int[] res = new int[2];
		for (int i = 1; i <= nums.length; ++i) {
			if (count[i] == 2)
				res[0] = i;
			if (count[i] == 0)
				res[1] = i;
		}
		return res;
	}
}
