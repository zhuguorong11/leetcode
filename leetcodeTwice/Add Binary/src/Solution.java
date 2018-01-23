/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "111";
		String b = "1";
		System.out.println(Solution.addBinary(a, b));
	}

	public static String addBinary(String a, String b) {
		if (a == null || a.length() == 0) {
			return b;
		}
		if (b == null || b.length() == 0) {
			return a;
		}
		char[] cha = a.toCharArray();
		char[] chb = b.toCharArray();
		int lenA = cha.length - 1;
		int lenB = chb.length - 1;

		int JinWei = 0;// ��λ
		int aNum = 0;// a
		int bNum = 0;// b
		int resByte = 0;// ���λ
		StringBuilder stringBuilder = new StringBuilder();
		while (lenA >= 0 || lenB >= 0 || JinWei == 1) {//��֤����ֵ����
			aNum = (lenA >= 0) ? Character.getNumericValue(cha[lenA--]) : 0;// �õ�a�ַ����ϵ����֣�����������ȣ���ֵΪ0
			bNum = (lenB >= 0) ? Character.getNumericValue(chb[lenB--]) : 0;// �õ�b�����ϵ����֣�����������ȣ���ֵΪ0
			resByte = (aNum + bNum + JinWei) % 2;
			JinWei = (aNum + bNum + JinWei) >= 2 ? 1 : 0;
			stringBuilder.insert(0, resByte);
		}
		return stringBuilder.toString();
	}
}
