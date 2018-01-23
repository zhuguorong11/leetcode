import java.util.ArrayList;
import java.util.List;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0)
			return res;
		String[] strsMap = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		res.add("");
		for (int i = 0; i < digits.length(); ++i) {
			int num = digits.charAt(i) - '0';
			while (res.get(0).length() == i) {//确保每个元素的长度是一致的
				String temp = res.remove(0);
				for (char ch : strsMap[num].toCharArray()) {
					res.add(temp + ch);
				}
			}
		}
		return res;
	}
}
