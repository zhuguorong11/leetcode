/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. '*' Matches any sequence of characters
 * (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		String p = "*";
		System.out.println(Solution.isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for(int i = 0; i < p.length(); ++i){
			if(p.charAt(i) == '*' && dp[0][i]){//跟*之前的字符没关系
				dp[0][i + 1] = true;
			}
		}
		for(int i = 0; i < s.length(); ++i){
			for(int j = 0; j < p.length(); ++j){
				if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
					dp[i + 1][j + 1] = dp[i][j];
				}else if(p.charAt(j) == '*'){
					/*
					 * a* counts as multiple a 
					   a* counts as single a
					 * */
					dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
