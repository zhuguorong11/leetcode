/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following:
 * 
 * 1. 1 2. 11 3. 21 4. 1211 5. 111221 1 is read off as "one 1" or 11. 11 is read
 * off as "two 1s" or 21. 21 is read off as "one 2, then one 1" or 1211. Given
 * an integer n, generate the nth term of the count-and-say sequence.
 * 
 * Note: Each term of the sequence of integers will be represented as a string.
 * 
 * Example 1:
 * 
 * Input: 1 Output: "1" Example 2:
 * 
 * Input: 4 Output: "1211"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		// initial
		StringBuilder cur = new StringBuilder("1");
		StringBuilder pre;
		for (int i = 1; i < n; ++i) {
			pre = cur;
			cur = new StringBuilder();
			int count = 1;
			char preNum = pre.charAt(0);
			int len = pre.length();
			for (int j = 1; j < len; ++j) {
				if (preNum == pre.charAt(j)) {
					++count;
				} else {
					cur.append(count).append(preNum);
					count = 1;
					preNum = pre.charAt(j);
				}
			}
			cur.append(count).append(preNum);
		}
		return cur.toString();
	}
}
