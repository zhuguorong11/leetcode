import java.util.Stack;

/**
 * Given a positive integer, output its complement number. The complement
 * strategy is to flip the bits of its binary representation.
 * 
 * Note: The given integer is guaranteed to fit within the range of a 32-bit
 * signed integer. You could assume no leading zero bit in the integer¡¯s binary
 * representation. Example 1: Input: 5 Output: 2 Explanation: The binary
 * representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2. Example 2: Input: 1 Output: 0 Explanation: The
 * binary representation of 1 is 1 (no leading zero bits), and its complement is
 * 0. So you need to output 0.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.findComplement(1));
	}

	public static int findComplement(int num) {
		Stack<Integer> stack = new Stack<>();
		while (num != 0) {
			int r = num % 2;
			if(r == 0)
				stack.push(1);
			else
				stack.push(0);
			num /= 2;
		}
		int res = 0;
		while (!stack.isEmpty()) {
			int len = stack.size();
			int r = stack.pop();
			res += (r << (len - 1));
		}
		return res;
	}
}
