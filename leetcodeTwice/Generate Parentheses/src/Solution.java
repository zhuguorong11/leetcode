import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		helper(res, "", n, n);
		return res;
	}

	// ��Ϊ��߲���(�������϶���Ҫ���ڻ��ߵ����ұ�)������������ͨ���������������п���
	public void helper(List<String> res, String s, int left, int right) {
		if (0 == right) {
			res.add(s);
		}
		if (left > 0) {
			helper(res, s + "(", left - 1, right);
		}
		if (right > left) {
			helper(res, s + ")", left, right - 1);
		}
	}
}
