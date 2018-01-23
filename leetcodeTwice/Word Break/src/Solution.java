import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words. You may assume the dictionary does
 * not contain duplicate words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict.isEmpty()) {
			return false;
		}
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;//initial
		for (int i = 1; i <= s.length(); ++i) {
			for (int j = 0; j < i; ++j) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;//dp[i]相当于设置一个断点
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
