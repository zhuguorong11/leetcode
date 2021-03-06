/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDistinct(String s, String t) {
		/*s contains t many times*/
		int[][] dp = new int[s.length() + 1][t.length() + 1];
		/*empty string is a subsequence of any string but only 1 time. So mem[i][0] = 1*/
		for(int i = 0; i <= s.length(); ++i){
			dp[i][0] = 1;
		}
		/* an empty string cannot contain a non-empty string as a substring, so the first column must be 0*/
		
		for (int i = 0; i < s.length(); ++i) {
			for (int j = 0; j < t.length(); ++j) {
				if(s.charAt(i) != t.charAt(j)){
					/*then we have the same number of distinct subsequences as we had without the new character*/
					dp[i + 1][j + 1] = dp[i][j + 1];
				}else{
					/* then the distinct number of subsequences: the number we had before plus the distinct 
					 * number of subsequences we had with less longer t and less longer s.*/
					dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
				}
			}
		}
		return dp[s.length()][t.length()];
	}
}
