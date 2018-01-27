package packageQuestion;

/**
 * ��������
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	 *  f[w] ��Ϊ����  
                         ��ʼ�������������
        1���������Ҫ������װ�����ʼ�� f[0] = 0, f[1~w] = -INF;  
        2���������Ҫ����װ�� f[0~v] = 0;  
	 */
	/*
	 * 01���� n����Ʒ���� m���������� w:ÿ����Ʒ������ v:ÿ����Ʒ�ļ�ֵ
	 */
	public int packageOfOneZero(int n, int m, int[] w, int[] v) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = m; j >= w[i]; --j) {
				// if (j >= w[i]) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
				// }
			}
		}
		return dp[m];
	}

	/*
	 * ��ȫ�������⣬�������޼�һ����Ʒ ����ͬ��
	 * ��01��������Ψһ��ͬ����j�Ǵ�0��M��01������������ǰһ�������⣨i-1����Ʒ���Ļ������������ǰ���⣨i����Ʒ����
	 * ��i-1����Ʒʱ�ı������ӵ�i����Ʒ������ȫ�����������ڽ����ǰ���⣨i����Ʒ������i����Ʒʱ�ı������ӵ�i����Ʒ��
	 */
	public int packageOfEntire(int n, int m, int[] w, int[] v) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < n; ++i) {
			for (int j = w[i]; j <= m; ++j) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		return dp[m];
	}
}