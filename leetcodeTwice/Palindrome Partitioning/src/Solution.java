import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab", Return
 * 
 * [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if (s == null || s.length() == 0)
			return res;
		helper(res, new ArrayList<>(), s, 0);
		return res;
	}
	public void helper(List<List<String>> res, List<String> cur, String string, int pos) {
		if (pos == string.length()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = pos; i < string.length(); ++i) {
			if (isPalindrome(string, pos, i)) {
				cur.add(string.substring(pos, i + 1));
				helper(res, cur, string, i + 1);
				cur.remove(cur.size() - 1);//backtracking
			}
		}
		return;
	}
	public boolean isPalindrome(String string, int low, int high) {
		while (low < high) {
			if (string.charAt(low++) != string.charAt(high--))
				return false;
		}
		return true;
	}
}
