/**
 * 
 * ��һ���������飬����ÿ�����Ĵ�С��ʹ�����ڵ��������Ĳ����һ������������target������ÿ�����Ĵ���Ϊ����ǰ��Ĳ�ľ���ֵ��
 * дһ���������������֮����С�Ƕ��١�
 * 
 * ע����� ����Լ���������ÿ��������������������С�ڵ���100��
 * 
 * ��ʽ��
 * 
 * ������������һ���������� num ��һ������target ����������С��������֮�͡�
 * 
 * ��������
 * 
 * num = [ 1��4��2��3 ] target = 1
 * 
 * �������
 * 
 * 2 // [ 2��3��2��3 ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 4, 2, 3 };
		System.out.println(Solution.minAdjustmentCost(nums, 1));
	}

	/*
	 * �����뱳������ i��ʾ�����i��Ԫ�أ�j��0 ��100���б�����dp[i][j]��ʾ��i��Ԫ�ر��j����С��������
	 */
	public static int minAdjustmentCost(int[] nums, int target) {
		if (nums.length < 2) {
			return 0;
		}
		int m = nums.length;
		long[][] dp = new long[m][101];/* 0 ~ 100 */
		/* inital first row */
		for (int i = 0; i < 101; ++i) {
			dp[0][i] = Math.abs(nums[0] - i);
		}
		/* i row just impact from i - 1 row */
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < 101; ++j) {
				dp[i][j] = Integer.MAX_VALUE;
				/* get diff */
				int diff = Math.abs(nums[i] - j);
				int max = Math.min(100, j + target);
				int min = Math.max(0, j - target);
				/*iterate from min to max*/
				for (int k = min; k <= max; ++k) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + diff);
				}
			}
		}
		long res = Long.MAX_VALUE;
		/*find the res at last row of minimum value*/
		for (int i = 0; i < 101; i++) {
			res = Math.min(res, dp[m - 1][i]);
		}
		return (int)res;
	}
}