/**
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseString(String s) {
		char[] chs = s.toCharArray();
		int end = chs.length - 1;
		int start = 0;
		while (start < end) {
			char temp = chs[start];
			chs[start] = chs[end];
			chs[end] = temp;
			++start;
			--end;
		}
		return new String(chs);
	}
}
