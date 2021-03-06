/**
 * Validate if a given string is numeric.
 * 
 * Some examples: "0" => true " 0.1 " => true "abc" => false "1 a" => false
 * "2e10" => true Note: It is intended for the problem statement to be
 * ambiguous. You should gather all requirements up front before implementing
 * one.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isNumber(String s) {
		s = s.trim();
		int len = s.length();
		if (len == 0) {
			return false;
		}
		boolean num = false;// 是否为数
		boolean ex = false;// 是否有exp
		boolean dot = false;// 是否有.
		char[] strs = s.toCharArray();
		for (int i = 0; i < len; ++i) {
			if (strs[i] >= '0' && strs[i] <= '9') {
				num = true;
			} else if (strs[i] == 'e') {
				if (ex) {
					return false;// 不可能出现两个e
				}
				if (!num) {
					return false;// 如果之前没整数，则肯定错
				}
				ex = true;
				dot = false;
				num = false;// 因为e后面肯定要根本数字
			} else if (strs[i] == '.') {
				if (dot) {
					return false;// 不可能有两个.
				}
				if (ex) {
					return false;// 如果之前有exp，则肯定错
				}
				dot = true;
			} else if (strs[i] == '+' || strs[i] == '-') {//考虑正负号
				if (num || dot) {//如果已经出现了数字或者小数点，则不可能再出现正负号了
					return false;
				}
			} else
				return false;
		}
		return num;
	}
}
