/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
		// 可以仿照该题第四题来做，把k赋值为2
		int len = prices.length;
		if (len <= 1)
			return 0;
		if (2 >= len / 2)// 当实际交易最多的次数小于k时，直接按照遍历即可           replace 2 by k
		{
			int maxProfits = 0;
			for (int i = 1; i < len; ++i) {
				if (prices[i - 1] < prices[i])
					maxProfits += prices[i] - prices[i - 1];
			}
			return maxProfits;
		}
		int[][] maxProfits = new int[3][len];  //here you can replace 3 by k+1,k means at most k transactions
		for (int i = 1; i <= 2; i++) {//replace 2 by k
			// temp means the maximum profit of just doing at most i-1 transactions,
			int temp = -prices[0];// 买入所需的钱
			for (int j = 1; j < len; j++) {
				// the maxprofits of current state when sell 卖出
				maxProfits[i][j] = Math.max(maxProfits[i][j - 1], prices[j] + temp);
				// the maxprofits of current state when buy 前一次交易后买入
				temp = Math.max(temp, maxProfits[i - 1][j - 1] - prices[j]);
			}
		}
		return maxProfits[2][len - 1];//replace 2 by k
	}
}
