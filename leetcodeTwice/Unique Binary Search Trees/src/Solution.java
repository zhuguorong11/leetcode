/*
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;// 空树和一个节点的树返回为0
		for (int i = 2; i <= n; i++) {// 以该节点为根节点
			for (int j = 1; j <= i; ++j) {//左边子树的节点数为j-1，右边子树节点数为i-j，把不同情况相加
				dp[i] += dp[j - 1] * dp[i - j];//笛卡尔积
			}
		}
		return dp[n];
	}
}
