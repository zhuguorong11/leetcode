/**
 * 有n个气球，编号为0到n-1，每个气球都有一个分数，存在nums数组中。每次吹气球i可以得到的分数为 nums[left] * nums[i] *
 * nums[right]， left和right分别表示i气球相邻的两个气球。当i气球被吹爆后，其左右两气球即为相邻。要求吹爆所有气球，得到最多的分数。
 * 
 * 样例 给出 [4, 1, 5, 10] 返回 270
 * 
 * nums = [4, 1, 5, 10] burst 1, 得分 4 * 1 * 5 = 20 nums = [4, 5, 10] burst 5, 得分
 * 4 * 5 * 10 = 200 nums = [4, 10] burst 4, 得分 1 * 4 * 10 = 40 nums = [10] burst
 * 10, 得分 1 * 10 * 1 = 10 总共的分数为 20 + 200 + 40 + 10 = 270
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 5, 10};
		System.out.println(Solution.maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		/* 现在数组首尾插入1 */
		int[] newNums = new int[nums.length + 2];
		int len = 1;
		for (int i : nums) {
			newNums[len++] = i;
		}
		newNums[0] = 1;
		newNums[len++] = 1;
		int[][] dp = new int[len][len];
		for (int i = 2; i < len; ++i) {
			for (int left = 0; left < len - i; ++left) {
				int right = left + i;
				for (int mid = left + 1; mid < right; ++mid) {
					dp[left][right] = Math.max(dp[left][right],
							newNums[left] * newNums[mid] * newNums[right] + dp[left][mid] + dp[mid][right]);
				}
			}
		}
		return dp[0][len - 1];
	}
}
