/**
 * '.' Matches any single character. 
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: bool isMatch(const char *s, const char *p)
 * 
 * Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		String p = ".*";
		System.out.println(Solution.isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		/* '*' Matches zero or more of the preceding element*/
		for (int i = 0; i < p.length(); ++i) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {//跟*之前的字符也有关系
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); ++i) {
			for (int j = 0; j < p.length(); ++j) {
				if (s.charAt(i) == p.charAt(j)) {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				} else if (p.charAt(j) == '*') {
					if(s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.'){
						/*in this case, a* only counts as empty*/
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					}else{
						/*s.charAt(i) == p.charAt(j - 1) or p.charAt(j) == '.'*/
						/*
						 * mabye a* counts as multiple a 
						 * 		 a* counts as single a
						 * 	     a* counts as empty
						 */
						dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j] || dp[i + 1][j - 1];
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}
