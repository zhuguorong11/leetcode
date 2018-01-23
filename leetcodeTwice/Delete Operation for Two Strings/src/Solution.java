/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * make word1 and word2 the same, where in each step you can delete one
 * character in either string.
 * 
 * Example 1: Input: "sea", "eat" Output: 2 Explanation: You need one step to
 * make "sea" to "ea" and another step to make "eat" to "ea".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 即找到最长公共子序列
	public int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return len1 + len2 - 2 * dp[len1][len2];
	}
}
