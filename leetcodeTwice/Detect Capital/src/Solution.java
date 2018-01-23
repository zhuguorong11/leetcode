/**
 * Given a word, you need to judge whether the usage of capitals in it is right
 * or not.
 * 
 * We define the usage of capitals in a word to be right when one of the
 * following cases holds:
 * 
 * All letters in this word are capitals, like "USA". All letters in this word
 * are not capitals, like "leetcode". Only the first letter in this word is
 * capital if it has more than one letter, like "Google". Otherwise, we define
 * that this word doesn't use capitals in a right way. Example 1: Input: "USA"
 * Output: True Example 2: Input: "FlaG" Output: False
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "FlaG";
		System.out.println(Solution.detectCapitalUse(string));
	}

	public static boolean detectCapitalUse(String word) {
		if (word.equals(word.toLowerCase()))
			return true;
		char[] chs = word.toCharArray();
		int len = chs.length;
		int upNum = 0;
		for (int i = 0; i < chs.length; i++) {
			if (chs[i] >= 'A' && chs[i] <= 'Z') {
				++upNum;
			}
		}
		if (chs[0] >= 'A' && chs[0] <= 'Z' && upNum == 1) {
			return true;
		} else if (upNum == len)
			return true;
		else
			return false;
	}
}
