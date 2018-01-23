/**
 * ���� n ����ͬ�������������� k��k < = n���Լ�һ��Ŀ�����֡����� n ���������ҳ� k ������ʹ���� k �����ĺ͵���Ŀ�����֣�дһ������ʵ���ҵ���ͬ�ķ���������
 */
package kth_sum;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1,2,3,4,6};
		System.out.println(Solution.kth(nums, 2, 5));
	}

	public static int kth(int[] nums, int k, int target) {

		// dp[k][target]��ʾk����ǰ�������Ϊtarget�ķ�������
		int[][] dp = new int[k + 1][target + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= nums.length; ++i) {
			for (int j = k; j >= 1; --j) {
				for (int s = target; s >= nums[i - 1]; --s) {
					dp[j][s] += dp[j - 1][s - nums[i - 1]];
				}
			}
		}
		return dp[k][target];
	}
}
