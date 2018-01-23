/**
 * 
 * 给一个整数数组，调整每个数的大小，使得相邻的两个数的差不大于一个给定的整数target，调整每个数的代价为调整前后的差的绝对值，
 * 写一个函数求调整代价之和最小是多少。
 * 
 * 注意事项： 你可以假设数组中每个整数都是正整数，且小于等于100。
 * 
 * 格式：
 * 
 * 输入依次输入一个整数数组 num 和一个数字target ，最后输出最小调整代价之和。
 * 
 * 样例输入
 * 
 * num = [ 1，4，2，3 ] target = 1
 * 
 * 样例输出
 * 
 * 2 // [ 2，3，2，3 ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 4, 2, 3 };
		System.out.println(Solution.minAdjustmentCost(nums, 1));
	}

	/*
	 * 类似与背包问题 i表示数组第i个元素，j从0 到100进行遍历。dp[i][j]表示第i个元素变成j的最小调整代价
	 */
	public static int minAdjustmentCost(int[] nums, int target) {
		if (nums.length < 2) {
			return 0;
		}
		int m = nums.length;
		long[][] dp = new long[m][101];/* 0 ~ 100 */
		/* inital first row */
		for (int i = 0; i < 101; ++i) {
			dp[0][i] = Math.abs(nums[0] - i);
		}
		/* i row just impact from i - 1 row */
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 101; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
				/* get diff */
				int diff = Math.abs(nums[i] - j);
				int max = Math.min(100, j + target);
				int min = Math.max(0, j - target);
				/*iterate from min to max*/
				for (int k = min; k <= max; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
				}
			}
		}
		long res = Long.MAX_VALUE;
		/*find the res at last row of minimum value*/
		for (int i = 0; i < 101; i++) {
			res = Math.min(res, dp[m - 1][i]);
		}
		return (int)res;
	}
}
