/**
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countSegments(String s) {
		// 除了第一个单词，其余每个单词前都是空格
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		int res = 0;
		for (int i = 0; i < len; i++) {
			if ((s.charAt(i) != ' ' && i == 0) || (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')) {
				++res;
			}
		}
		return res;
	}
}
