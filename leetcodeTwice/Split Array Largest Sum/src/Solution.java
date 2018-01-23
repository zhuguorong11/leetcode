/**
 * Given an array which consists of non-negative integers and an integer m, you
 * can split the array into m non-empty continuous subarrays. Write an algorithm
 * to minimize the largest sum among these m subarrays.
 * 
 * Note: If n is the length of array, assume the following constraints are
 * satisfied:
 * 
 * 1 ¡Ü n ¡Ü 1000 1 ¡Ü m ¡Ü min(50, n) Examples:
 * 
 * Input: nums = [7,2,5,10,8] m = 2
 * 
 * Output: 18
 * 
 * Explanation: There are four ways to split nums into two subarrays. The best
 * way is to split it into [7,2,5] and [10,8], where the largest sum among the
 * two subarrays is only 18.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int splitArray(int[] nums, int m) {
		// object is finding min(max( m sum of subarray))
		// find max of nums as left boundary,and sum of nums as right
		// boundary,that means the result must between [left,right]
		long sum = 0;
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
			sum += num;
		}
		long left = max;
		long right = sum;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if(!isValid(mid, nums, m))
				left = mid + 1;
			else
				right = mid - 1;
		}
		return (int)left;
	}
	public boolean isValid(long targetSum, int[] nums, int m) {
		int count = 1;// begin of split,every nums has 1 split of ownself
		long sum = 0;
		for (int num : nums) {
			sum += num;
			if (sum > targetSum) {
				sum = num;
				++count;
				//means when split m subarrays,there has left some numbers,so we should increase mid
				//so in the function splitArray,we should let left = mid + 1;
				if (count > m)
					return false;
			}
		}
		//we used up all numbers before we reach m,so we should decrease mid
		//so in the function splitArray,we should let right = mid - 1 to find minimum;
		return true;
	}
}
