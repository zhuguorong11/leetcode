/**
 * Given a string representing an expression of fraction addition and
 * subtraction, you need to return the calculation result in string format. The
 * final result should be irreducible fraction. If your final result is an
 * integer, say 2, you need to change it to the format of fraction that has
 * denominator 1. So in this case, 2 should be converted to 2/1.
 * 
 * Example 1: Input:"-1/2+1/2" Output: "0/1" Example 2: Input:"-1/2+1/2+1/3"
 * Output: "1/3" Example 3: Input:"1/3-1/2" Output: "-1/6" Example 4:
 * Input:"5/3+1/3" Output: "2/1"
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String fractionAddition(String expression) {
		String[] strs = expression.split("(?=[-,+])");
		String res = "0/1";// initial
		for (String string : strs) {
			String[] num1 = string.split("/");
			String[] num2 = res.split("/");
			int num1FenZi = Integer.parseInt(num1[0]);
			int num1FenMu = Integer.parseInt(num1[1]);
			int num2FenZi = Integer.parseInt(num2[0]);
			int num2FenMu = Integer.parseInt(num2[1]);
			// 分子*分母相加
			int fenZi = num1FenZi * num2FenMu + num2FenZi * num1FenMu;
			int fenMu = num1FenMu * num2FenMu;
			if (fenZi == 0)
				res = "0/1";
			else {
				// 判断符号
				boolean sign = fenZi * fenMu < 0;
				fenZi = Math.abs(fenZi);
				fenMu = Math.abs(fenMu);
				// 分子、分母约分,先得到最大公约数
				int gcd = GCD(fenZi, fenMu);
				res = (sign ? "-" : "") + fenZi / gcd + "/" + fenMu / gcd;
			}
		}
		return res;
	}

	public int GCD(int fenZi, int fenMu) {
		while (fenMu != 0) {
			int temp = fenMu;
			fenMu = fenZi % fenMu;
			fenZi = temp;
		}
		return fenZi;
	}
}
