/**
 * Given an array of integers nums and a positive integer k, find whether it's
 * possible to divide this array into k non-empty subsets whose sums are all
 * equal.
 * 
 * Example 1: Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4 Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3),
 * (2,3) with equal sums. Note:
 * 
 * 1 <= k <= len(nums) <= 16. 0 < nums[i] < 10000.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (k <= 0 || sum % k != 0) {
			return false;
		}
		sum /= k;
		boolean[] visited = new boolean[nums.length];
		return dfs(nums, visited, k, 0, 0, sum, 0);
	}

	public boolean dfs(int[] nums, boolean[] visited, int k, int curNum, int curSum, int target, int start) {
		if (k == 1) {
			return true;
		}
		if (curSum == target && curNum > 0) {
			return dfs(nums, visited, k - 1, 0, 0, target, 0);
		}
		for (int i = start; i < nums.length; ++i) {
			if (!visited[i]) {
				visited[i] = true;
				if(dfs(nums, visited, k, curNum++, curSum + nums[i], target, i + 1)){
					return true;
				}
				visited[i] = false;
			}
		}
		return false;
	}
}
