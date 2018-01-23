import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, path = "/home/", => "/home" path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases: Did you consider the case where path = "/../"? In this case,
 * you should return "/". Another corner case is the path might contain multiple
 * slashes '/' together, such as "/home//foo/". In this case, you should ignore
 * redundant slashes and return "/home/foo".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/abc/...";
		System.out.println(Solution.simplifyPath(path));
	}

	public static String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "";
		}
		Stack<String> stack = new Stack<>();
		HashSet<String> set = new HashSet<>(Arrays.asList("..", ".", ""));
		for (String token : path.split("/")) {
			if (token.equals("..") && !stack.isEmpty()) {
				stack.pop();
			} else if (!set.contains(token)) {
				stack.push(token);
				// System.out.println(token);
			}
		}
		String reString = "";
		while (!stack.isEmpty()) {
			reString = "/" + stack.pop() + reString;
		}
		if (reString == "") {
			return "/";
		} else {
			return reString;
		}
	}
}
