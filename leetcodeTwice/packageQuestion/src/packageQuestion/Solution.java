package packageQuestion;

/**
 * 背包问题
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 *  f[w] 即为所求  
                         初始化分两种情况：
        1、如果背包要求正好装满则初始化 f[0] = 0, f[1~w] = -INF;  
        2、如果不需要正好装满 f[0~v] = 0;  
	 */
	/*
	 * 01背包 n：物品个数 m：背包重量 w:每个物品的重量 v:每个物品的价值
	 */
	public int packageOfOneZero(int n, int m, int[] w, int[] v) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = m; j >= w[i]; --j) {
				// if (j >= w[i]) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
				// }
			}
		}
		return dp[m];
	}

	/*
	 * 完全背包问题，可以无限加一个物品 参数同上
	 * 和01背包问题唯一不同的是j是从0到M。01背包问题是在前一个子问题（i-1种物品）的基础上来解决当前问题（i种物品），
	 * 向i-1种物品时的背包添加第i种物品；而完全背包问题是在解决当前问题（i种物品），向i种物品时的背包添加第i种物品。
	 */
	public int packageOfEntire(int n, int m, int[] w, int[] v) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = w[i]; j <= m; ++j) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		return dp[m];
	}
}
