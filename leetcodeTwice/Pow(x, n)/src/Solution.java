//Implement pow(x, n).
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.myPow(2, 10));
		}

	public static double myPow(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 0)
			return 0;
		// n�Ƿ�Ϊ����
		if (n < 0) {
			// ���Ϊ����С
			if (n == Integer.MIN_VALUE)
				return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);//Integer.MAX_VALUE�ľ���ֵ��Integer.MIN_VALUEС1������Ҫ���һ��x
			else
				return 1.0 / (myPow(x, -n));
		}
		// �ж�n�Ƿ�Ϊż��
		return ((n & 1) == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
