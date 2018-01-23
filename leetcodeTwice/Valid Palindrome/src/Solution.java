import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? This is a good
 * question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {
		int len = s.length();
		if (len == 0)
			return true;
		s = s.toLowerCase();
		char[] chs = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < chs.length; i++) {
			// 因为是只要求数字和字母
			if (chs[i] >= '0' && chs[i] <= '9' || chs[i] >= 'a' && chs[i] <= 'z') {
				stack.push(chs[i]);
				queue.add(chs[i]);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.pop() != queue.poll()) {
				return false;
			}
		}
		return true;
	}
}
