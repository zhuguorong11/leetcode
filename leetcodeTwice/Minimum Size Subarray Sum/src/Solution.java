/*
 * Given an array of n positive integers and a positive integer s, 
 find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] nums) {
		// 利用窗口滑动
		int len = nums.length;
		int start = 0, end = 0, curSum = 0, minLength = Integer.MAX_VALUE;
		while (end < len) {
			//先让end指针进行移动
			while (end < len && curSum < s) {
				curSum += nums[end++];
			}
			// 此情况说明所以的数加起来都没有大于等于s
			if (curSum < s)
				break;
			// 此时curSum正好达到>=s

			//让start指针进行移动
			while (start < end && curSum >= s) {
				curSum -= nums[start++];
			}
			if ((end - start + 1) < minLength)
				minLength = (end - start + 1);// 因为此时的start多+1，所以用end-start后还要+1
		}
		// 通过对minLength来判断，是否进行了长度比较操作
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
