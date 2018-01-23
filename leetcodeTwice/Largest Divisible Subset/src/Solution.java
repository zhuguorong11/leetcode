import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that
 * every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj %
 * Si = 0.
 * 
 * If there are multiple solutions, return any subset is fine.
 * 
 * Example 1:
 * 
 * nums: [1,2,3]
 * 
 * Result: [1,2] (of course, [1,3] will also be ok) Example 2:
 * 
 * nums: [1,2,4,8]
 * 
 * Result: [1,2,4,8]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		int[] dp = new int[nums.length];
		dp[0] = 1;
		
		//The array int[] dp is initialized with value 0 for each element. However, it should be 1, 
		//since it can be divided by itself 
		Arrays.fill(dp, 1);
		// for each element in nums, find the length of largest subset it has.
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			//dp[i] = dp[i] > 0 ? dp[i] : 1; // Just added this line.因为任何数字他本身的个数为1，不可能为0
		}

		// pick the index of the largest element in dp.
		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
			maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
		}
		// from nums[maxIndex] to 0, add every element belongs to the largest
		// subset.
		int temp = nums[maxIndex];
		int curDp = dp[maxIndex];
		for (int i = maxIndex; i >= 0; i--) {
			if (temp % nums[i] == 0 && dp[i] == curDp) {
				res.add(nums[i]);
				temp = nums[i];
				curDp--;
			}
		}
		return res;
	}
}
