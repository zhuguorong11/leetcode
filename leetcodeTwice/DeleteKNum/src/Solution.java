/**
 * ����һ���ַ��� A����ʾһ�� n λ������, ɾ������ k λ����, ʹ��ʣ���������Ȼ����ԭ����˳�����в���һ���µ���������дһ�������ҵ�ɾ�� k
 * ������֮�����С������������ N <= 240��k <= N��
 * 
 * ��ʽ��
 * 
 * ��������������һ���ַ�������������� A ��һ������ k��������ɾ�� k ������֮�����С��������
 * 
 * ��������
 * 
 * A = 178542 k = 4
 * 
 * �������
 * 
 * 12
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.deleteNum("178542", 3));
	}

	public static int deleteNum(String num, int k) {
		if (num.length() <= k) {
			return 0;
		}
		int i = 0;
		while (k-- != 0) {
			i = 0;
			while (i < num.length() - 1 && num.charAt(i) < num.charAt(i + 1)) {
				++i;
			}
			num = num.substring(0, i) + num.substring(i + 1, num.length());
		}

		// maybe start with 00... like 111000 k=3
		for (i = 0; num.charAt(i) == '0'; ++i)
			;
		num = num.substring(i);
		return Integer.parseInt(num);
		
	}
}
