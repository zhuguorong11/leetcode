import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {
		String s = "()";
		System.out.println(Solution.isValid(s));
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chs = s.toCharArray();
		int len = chs.length;
		// boolean valid = true;
		for (int i = 0; i < len; i++) {
			if (chs[i] == '(' || chs[i] == '[' || chs[i] == '{') {
				stack.push(chs[i]);
			}
			else if (chs[i] == ')') {
				if (!stack.isEmpty()) {
					char ch = stack.pop();
					if (ch != '(')
						return false;
				} else
					return false;
			} else if (chs[i] == ']') {
				if (!stack.isEmpty()) {
					char ch = stack.pop();
					if (ch != '[')
						return false;
				} else
					return false;
			} else {
				if (!stack.isEmpty()) {
					char ch = stack.pop();
					if (ch != '{')
						return false;
				} else
					return false;
			}
		}
		if (!stack.isEmpty()) {
			return false;
		}
		return true;
	}
}
