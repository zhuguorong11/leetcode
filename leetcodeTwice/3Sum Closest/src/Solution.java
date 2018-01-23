import java.util.Arrays;

/*
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
		int sum = 0;
		if (len <= 3) {
			for (int i = 0; i < len; i++) {
				sum += nums[i];
			}
			return sum;
		}
		Arrays.sort(nums);
		int res = nums[0] + nums[1] + nums[len - 1];// ³õÊ¼»¯
		int i = 0;
		while (i < len - 2) {
			int iNext = i + 1;
			int end = len - 1;
			while (iNext < end) {
				sum = nums[i] + nums[iNext] + nums[len - 1];
				if (sum == target)
					return sum;
				else if (sum > target)
					--end;
				else
					++iNext;
				if (Math.abs(sum - target) < Math.abs(res - target))
					res = sum;
			}
			++i;
		}
		return res;
	}
}
