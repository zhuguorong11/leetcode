/**
 * You are given coins of different denominations and a total amount of money
 * amount. Write a function to compute the fewest number of coins that you need
 * to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 * 
 * Example 1: coins = [1, 2, 5], amount = 11 return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2: coins = [2], amount = 3 return -1.
 * 
 * Note: You may assume that you have an infinite number of each kind of coin.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0)
			return -1;
		int len = coins.length;
		int[] dpMoney = new int[amount + 1];
		for (int i = 1; i <= amount; ++i) {
			// dpMoney[i]表示兑换i钱需要多少个硬币
			// 先初始化每个i情况的硬币数
			dpMoney[i] = Integer.MAX_VALUE;
			for (int j = 0; j < len; ++j) {
				if (i >= coins[j] && dpMoney[i - coins[j]] != Integer.MAX_VALUE) {// && dpMoney[i - coins[j]] != Integer.MAX_VALUE
					dpMoney[i] = Math.min(dpMoney[i], dpMoney[i - coins[j]] + 1);
				}
			}
		}
		if (dpMoney[amount] == Integer.MAX_VALUE) {
			return -1;
		}
		return dpMoney[amount];
	}
}
