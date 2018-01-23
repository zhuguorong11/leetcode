/*
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.numDecodings("0123211"));
	}

	public static int numDecodings(String s) {
		int len = s.length();
		if (len == 0 || s == null)
			return 0;
		int[] dp = new int[len + 1];
		dp[0] = 1;
		// 当s.charAt(0)为0时，即不能生成任何码，则dp[1]只能为0;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;// 第一个数字

		// dp[i]代表在i之前的字符串所能得到的解码数量之和
		for (int i = 2; i <= len; i++) {
			int one = Integer.valueOf(s.substring(i - 1, i));
			int two = Integer.valueOf(s.substring(i - 2, i));
			if (one >= 1 && one <= 9) {
				dp[i] += dp[i - 1];
			}
			if (two >= 10 && two <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[len];
	}
}
