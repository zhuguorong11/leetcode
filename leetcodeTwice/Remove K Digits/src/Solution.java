import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be ¡Ý k. The given num
 * does not contain any leading zero. Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest. Example
 * 2:
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * 
 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
 * the number and it is left with nothing which is 0.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String removeKdigits(String num, int k) {
		int len = num.length();
		if (k >= len)
			return "0";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < len; ++i) {
			// find the smaller num than preValue
			while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(i)) {
				stack.pop();
				--k;
			}
			stack.push(num.charAt(i));
		}
		//avoid some case such 1111111111111  or 112223333 12345 ascending,we should pop left k number
		while(k != 0)
		{
			stack.pop();
			--k;
		}
		//use StringBuilder
		StringBuilder sBuilder = new StringBuilder();
		while(!stack.isEmpty())
			sBuilder.append(stack.pop());
		//reverse the sbuilder
		sBuilder.reverse();
		while(sBuilder.length() > 1 && sBuilder.charAt(0) == '0')
			sBuilder.deleteCharAt(0);
		return sBuilder.toString();
	}
}
