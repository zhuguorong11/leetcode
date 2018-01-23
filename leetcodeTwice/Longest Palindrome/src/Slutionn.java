import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author zhugr
 *
 */
public class Slutionn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestPalindrome(String s) {
		char[] chs = s.toCharArray();
		int len = chs.length;
		if (len == 0)
			return 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : chs) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		int res = 0;
		int mid = 0;// if has odd time
		Iterator<Character> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			char ch = iterator.next();
			int time = map.get(ch);
			if ((time & 1) == 1) {
				res += (time - 1);
				mid = 1;
			} else
				res += time;
		}
		return res + mid;
	}

}
