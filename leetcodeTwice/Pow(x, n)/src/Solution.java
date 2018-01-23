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
		// n是否为负数
		if (n < 0) {
			// 如果为无穷小
			if (n == Integer.MIN_VALUE)
				return 1.0 / (myPow(x, Integer.MAX_VALUE) * x);//Integer.MAX_VALUE的绝对值比Integer.MIN_VALUE小1，所以要多乘一个x
			else
				return 1.0 / (myPow(x, -n));
		}
		// 判断n是否为偶数
		return ((n & 1) == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
	}
}
