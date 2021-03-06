/**
 * iven s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * 
 * For example, Given: s1 = "aabcc", s2 = "dbbca",
 * 
 * When s3 = "aadbbcbcac", return true. When s3 = "aadbbbaccc", return false.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if (len1 + len2 != len3) {
			return false;
		}
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		/*
		 * DP table represents if s3 is interleaving at (i+j)th position when s1
		 * is at ith position, and s2 is at jth position. 0th position means
		 * empty string.
		 */
		for (int i = 0; i <= len1; ++i) {
			for (int j = 0; j <= len2; ++j) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
				} else {
					dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)))
							|| (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
				}
			}
		}
		return dp[len1][len2];
	}
}
