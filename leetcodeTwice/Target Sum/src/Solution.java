/*
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. 
 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int res = 0;

	public int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		helper(nums, S, 0, 0);
		return res;
	}

	public void helper(int[] nums, int S, int pos, int curSum) {
		if (pos == nums.length) {
			if (S == curSum) {
				++res;	
			}
			return;
		}
		helper(nums, S, pos + 1, curSum + nums[pos]);
		helper(nums, S, pos + 1, curSum - nums[pos]);
	}
}
