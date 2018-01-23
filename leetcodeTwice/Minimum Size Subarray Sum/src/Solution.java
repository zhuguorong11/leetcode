/*
 * Given an array of n positive integers and a positive integer s, 
 find the minimal length of a subarray of which the sum �� s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] nums) {
		// ���ô��ڻ���
		int len = nums.length;
		int start = 0, end = 0, curSum = 0, minLength = Integer.MAX_VALUE;
		while (end < len) {
			//����endָ������ƶ�
			while (end < len && curSum < s) {
				curSum += nums[end++];
			}
			// �����˵�����Ե�����������û�д��ڵ���s
			if (curSum < s)
				break;
			// ��ʱcurSum���ôﵽ>=s

			//��startָ������ƶ�
			while (start < end && curSum >= s) {
				curSum -= nums[start++];
			}
			if ((end - start + 1) < minLength)
				minLength = (end - start + 1);// ��Ϊ��ʱ��start��+1��������end-start��Ҫ+1
		}
		// ͨ����minLength���жϣ��Ƿ�����˳��ȱȽϲ���
		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}
}
