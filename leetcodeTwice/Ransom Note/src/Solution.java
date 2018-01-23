/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		// only use once
		int[] chs = new int[26];// lowercase letter
		for (int i = 0; i < magazine.length(); i++) {
			++chs[magazine.charAt(i) - 'a'];
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			if (--chs[ransomNote.charAt(i) - 'a'] < 0)
				return false;
		}
		return true;
	}
}
