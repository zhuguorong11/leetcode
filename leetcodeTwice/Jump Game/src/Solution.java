/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.


 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len == 0)
			return false;
		int canReachMax = 0;// 初始化能跳跃的最大距离
		for (int i = 0; i < nums.length; i++) {
			if (i > canReachMax)
				return false;
			else
				canReachMax = Math.max(canReachMax, nums[i] + i);
		}
		return true;
	}
}
