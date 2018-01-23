import java.lang.Thread.State;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.Instrument;

/**
 * ' Write a function that takes a string as input and reverse only the vowels
 * of a string.
 * 
 * Example 1: Given s = "hello", return "holle".
 * 
 * Example 2: Given s = "leetcode", return "leotcede".
 * 
 * Note: The vowels does not include the letter "y".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello";
		System.out.println(Solution.reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('o');
		set.add('u');
		set.add('i');
		set.add('A');
		set.add('E');
		set.add('I');
		set.add('O');
		set.add('U');
		int len = s.length();
		char[] chs = s.toCharArray();
		int start = 0;
		int end = len - 1;
		while (start < end) {
			while (!set.contains(chs[start]) && start < end)
				++start;
			while (!set.contains(chs[end]) && start < end)
				--end;
			char temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
			++start;
			--end;
		}
		return new String(chs);
	}
}
