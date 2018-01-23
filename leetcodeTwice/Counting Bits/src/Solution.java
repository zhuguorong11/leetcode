/**
 * Given a non negative integer number num. For every numbers i in the range 0 ��
 * i �� num calculate the number of 1's in their binary representation and return
 * them as an array.
 * 
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 * 
 * Follow up:
 * 
 * It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass? Space complexity should be O(n). Can you do it like a boss? Do
 * it without using any builtin function like __builtin_popcount in c++ or in
 * any other language.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;

		// ����2���ݴη������жϣ���0,1,2-3,4-7,8-15....���Ƶķֳ�һ�飬��5���൱����4+1��13�뵱��8+5
		// ���Գ�ʼ��һ��pow����ʾ2���ݴη�
		int pow = 1;
		// t�����2^n��2^(n+1)-1֮��ĸ���
		for (int i = 1, t = 0; i <= num; ++i, ++t) {
			if (i == pow) {
				pow *= 2;
				t = 0;
			}
			dp[i] = dp[t] + 1;
		}
		return dp;
	}
}
