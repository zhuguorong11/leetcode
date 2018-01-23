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
		int[] res = new int[len1 + len2];// �������len1+len2λ���
		for (int i = len1 - 1; i >= 0; --i) {
			for (int j = len2 - 1; j >= 0; --j) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');// �������2λ
				// ��λ��λ��Ϊi+j �� i+j+1������i+j+1��Ϊ����λ�ã�i+j��Ϊ��λ��λ��
				int carryIndex = i + j, modeIndex = i + j + 1;
				int sum = mul + res[modeIndex];
				res[carryIndex] += sum / 10;// ��Ϊ��λλ���ϻ��ж��������֣���Ҫ�����ۼ�
				res[modeIndex] = sum % 10;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		for (int x : res) {
			// ��ͷΪ0�Ĳ�Ҫ
			if (sBuilder.length() != 0 || x != 0)
				sBuilder.append(x);
		}
		// ���Ϊ�գ��򷵻�0
		return sBuilder.length() == 0 ? "0" : sBuilder.toString();
	}
}
