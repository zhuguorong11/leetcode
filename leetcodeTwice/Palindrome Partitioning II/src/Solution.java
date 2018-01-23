/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return 1 since the palindrome partitioning
 * ["aa","b"] could be produced using 1 cut.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minCut(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int[] cut = new int[len];// cuts[i] will store the minimum no. of cuts
									// required for substring [0...i];
		boolean[][] isPal = new boolean[len][len];// store isPal[i][j] to
													// judges[i:j] is
													// palindromic
		for (int i = 0; i < len; ++i) {
			/*
			 * since every single character is a palindrome, maximum no. of cuts
			 * for substring [0...i] will be i so initiating cuts[i] with
			 * maximum possible value
			 */
			cut[i] = i;
			for (int j = 0; j <= i; ++j) {
				if (j == i)
					isPal[j][i] = true;
				else {
					if (s.charAt(j) != s.charAt(i))
						continue;
					if (j == i - 1)
						isPal[j][i] = true;
					else
						isPal[j][i] = isPal[j + 1][i - 1];
				}
				if (isPal[j][i]) {
					if (j == 0)// no need to cut
						cut[i] = 0;
					else {
						cut[i] = Math.min(cut[i], cut[j - 1] + 1);
					}
				}
			}
		}
		return cut[len - 1];
	}

	// TLE
//	public int minCut(String s) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		if (s == null || s.length() == 0)
//			return 0;
//		helper(res, new ArrayList<>(), s, 0);
//		int min = Integer.MAX_VALUE;
//		for (List<String> list : res) {
//			min = Math.min(min, list.size());
//		}
//		return min - 1;
//	}
//
//	public void helper(List<List<String>> res, List<String> cur, String string, int pos) {
//		if (pos == string.length()) {
//			res.add(new ArrayList<>(cur));
//			return;
//		}
//		for (int i = pos; i < string.length(); ++i) {
//			if (isPalindrome(string, pos, i)) {
//				cur.add(string.substring(pos, i + 1));
//				helper(res, cur, string, i + 1);
//				cur.remove(cur.size() - 1);
//			}
//		}
//		return;
//	}
//
//	public boolean isPalindrome(String string, int low, int high) {
//		while (low < high) {
//			if (string.charAt(low++) != string.charAt(high--))
//				return false;
//		}
//		return true;
//	}
}
