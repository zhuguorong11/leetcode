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
		dp[0] = dp[1] = 1;// ������һ���ڵ��������Ϊ0
		for (int i = 2; i <= n; i++) {// �Ըýڵ�Ϊ���ڵ�
			for (int j = 1; j <= i; ++j) {//��������Ľڵ���Ϊj-1���ұ������ڵ���Ϊi-j���Ѳ�ͬ������
				dp[i] += dp[j - 1] * dp[i - j];//�ѿ�����
			}
		}
		return dp[n];
	}
}
