/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. \ (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * a) Insert a character b) Delete a character c) Replace a character
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*from bottom to top*/
	public int minDistance(String word1, String word2) {
		/*use dp[i][j] to means do operation from word1(0,i) to word2(0,j)*/
		/*
		 * do operation of insert, dp[i][j] = dp[i-1][j] + 1;
		 * do operation of delete, dp[i][j] = dp[i][j-1] + 1;
		 * do operation of replace, dp[i][j] = dp[i-1][j-1] + 1;
		 */
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		/*initial 从word1的第i个位置delete到空字符串需要多少操作*/
		for(int i = 0; i <= len1; ++i){
			dp[i][0] = i;
		}
		/*initial 从word1的空字符串到word2的第i个位置，需要insert多少次*/
		for(int i = 0; i <= len2; ++i){
			dp[0][i] = i;
		}
		for(int i = 1; i <= len1; ++i){
			for(int j = 1; j <= len2; ++j){
				if(word1.charAt(i - 1) == word2.charAt(j - 1))
				{
					dp[i][j] = dp[i - 1][j - 1];
				}else{
					dp[i][j] = Math.min(dp[i - 1][j - 1],Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[len1][len2];
	}
	
	/*from top to bottom*/
	public int minDistance2(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		return helper(len1, len2, word1, word2, new int[len1 + 1][len2 + 1]);
	}
	public int helper(int i, int j, String word1, String word2, int[][] dp){
		if(i == 0){
			return j;
		}
		if(j == 0){
			return i;
		}
		if(dp[i][j] != 0){
			return dp[i][j];
		}
		if(word1.charAt(i - 1) == word2.charAt(j - 1)){
			return helper(i - 1, j - 1, word1, word2, dp);
		}else{
			int insertOp = helper( i- 1, j, word1, word2, dp);
			int deleteOp = helper( i, j - 1, word1, word2, dp);
			int replacetOp = helper( i- 1, j - 1, word1, word2, dp);
			dp[i][j] = Math.min(insertOp, Math.min(deleteOp, replacetOp)) + 1;
			return dp[i][j];
		}
	}
}
