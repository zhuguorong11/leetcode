/**
 * ��n�����򣬱��Ϊ0��n-1��ÿ��������һ������������nums�����С�ÿ�δ�����i���Եõ��ķ���Ϊ nums[left] * nums[i] *
 * nums[right]�� left��right�ֱ��ʾi�������ڵ��������򡣵�i���򱻴�����������������Ϊ���ڡ�Ҫ�󴵱��������򣬵õ����ķ�����
 * 
 * ���� ���� [4, 1, 5, 10] ���� 270
 * 
 * nums = [4, 1, 5, 10] burst 1, �÷� 4 * 1 * 5 = 20 nums = [4, 5, 10] burst 5, �÷�
 * 4 * 5 * 10 = 200 nums = [4, 10] burst 4, �÷� 1 * 4 * 10 = 40 nums = [10] burst
 * 10, �÷� 1 * 10 * 1 = 10 �ܹ��ķ���Ϊ 20 + 200 + 40 + 10 = 270
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4, 1, 5, 10};
		System.out.println(Solution.maxCoins(nums));
	}

	public static int maxCoins(int[] nums) {
		/* ����������β����1 */
		int[] newNums = new int[nums.length + 2];
		int len = 1;
		for (int i : nums) {
			newNums[len++] = i;
		}
		newNums[0] = 1;
		newNums[len++] = 1;
		int[][] dp = new int[len][len];
		for (int i = 2; i < len; ++i) {
			for (int left = 0; left < len - i; ++left) {
				int right = left + i;
				for (int mid = left + 1; mid < right; ++mid) {
					dp[left][right] = Math.max(dp[left][right],
							newNums[left] * newNums[mid] * newNums[right] + dp[left][mid] + dp[mid][right]);
				}
			}
		}
		return dp[0][len - 1];
	}
}
