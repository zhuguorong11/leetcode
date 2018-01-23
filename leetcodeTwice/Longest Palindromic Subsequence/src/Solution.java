/*
 * Given a string s, find the longest palindromic subsequence's length in s. 
 * You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "bbbab";
		System.out.println(Solution.longestPalindromeSubseq2(string));
	}

	public int longestPalindromeSubseq(String s) {
		char[] chrs = s.toCharArray();
		int len = chrs.length;
		if (len == 0) {
			return 0;
		}

		int[][] dp = new int[len][len];
		// 对对角线进行初始化，对角线值为1，因为一个字母肯定是回文
		for (int i = 0; i < dp.length; ++i) {
			dp[i][i] = 1;
		}
		for (int i = len - 1; i >= 0; --i) {
			for (int j = i + 1; j < len; ++j) {
				if (chrs[i] == chrs[j]) {
					dp[i][j] = dp[i + 1][j - 1] + 2;// 回文每次肯定+2
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][len - 1];
	}

	public static int longestPalindromeSubseq2(String s) {
		char[] chrs = s.toCharArray();
		int len = chrs.length;
		if (len == 0) {
			return 0;
		}

		int[][] dp = new int[len][len];
		// 对对角线进行初始化，对角线值为1，因为一个字母肯定是回文
		for (int i = 0; i < dp.length; ++i) {
			dp[i][i] = 1;
		}
		for (int i = 0; i < len; ++i) {
			for (int j = i - 1; j >= 0; --j) {
				if (chrs[i] == chrs[j]) {
					dp[i][j] = dp[i - 1][j + 1] + 2;// 回文每次肯定+2
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[len - 1][0];
	}
}
