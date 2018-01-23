/**
 * Given two strings representing two complex numbers.
 * 
 * You need to return a string representing their multiplication. Note i2 = -1
 * according to the definition.
 * 
 * Example 1: Input: "1+1i", "1+1i" Output: "0+2i" Explanation: (1 + i) * (1 +
 * i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 * Example 2: Input: "1+-1i", "1+-1i" Output: "0+-2i" Explanation: (1 - i) * (1
 * - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * 
 * @author zhugr
 *
 */
public class Solution {
	public static void main(String[] args) {

	}

	public String complexNumberMultiply(String a, String b) {
		String[] aa = a.split("\\+");
		String[] bb = b.split("\\+");//+Îª×ªÒå×Ö·û
		
		int numA1 = Integer.parseInt(aa[0]);
		int numA2 = Integer.parseInt(aa[1].replace("i", ""));
		
		int numB1 = Integer.parseInt(bb[0]);
		int numB2 = Integer.parseInt(bb[1].replace("i", ""));
		
		int real = (numA1 * numB1) + (-numA2 * numB2);
		int image = (numA1 * numB2) + (numA2 * numB1);
		
		return real + "+" + image +"i";
	}
}
