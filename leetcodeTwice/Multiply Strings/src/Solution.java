/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2.
 * 
 * Note:
 * 
 * The length of both num1 and num2 is < 110. Both num1 and num2 contains only
 * digits 0-9. Both num1 and num2 does not contain any leading zero. You must
 * not use any built-in BigInteger library or convert the inputs to integer
 * directly.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "";
		String num2 = "";
		System.out.println(Solution.multiply(num1, num2));
	}

	public static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		int[] res = new int[len1 + len2];// 最多生成len1+len2位结果
		for (int i = len1 - 1; i >= 0; --i) {
			for (int j = len2 - 1; j >= 0; --j) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');// 最多生成2位
				// 两位的位置为i+j 和 i+j+1，其中i+j+1的为余数位置，i+j的为进位数位置
				int carryIndex = i + j, modeIndex = i + j + 1;
				int sum = mul + res[modeIndex];
				res[carryIndex] += sum / 10;// 因为进位位置上会有多个结果出现，需要进行累加
				res[modeIndex] = sum % 10;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int x : res) {
			// 开头为0的不要
			if (sBuilder.length() != 0 || x != 0)
				sBuilder.append(x);
		}
		// 结果为空，则返回0
		return sBuilder.length() == 0 ? "0" : sBuilder.toString();
	}
}
