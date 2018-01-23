import java.util.Arrays;

/**
 * �� N ��С��վ��һ�С�ÿ��С����һ����������������Ҫ�󣬸�С�����ǹ��� 1��ÿ��С�����ٵõ�һ���ǹ���
 * 2������Խ�ߵ�С�����Ա������ڵ�����С���õ�������ǹ��� дһ����������������׼�������ǹ���
 * 
 * ��ʽ��
 * 
 * �����һ�������������С�����������飬���������Ҫ׼�����ٵ��ǹ���������
 * 
 * ��������
 * 
 * [ 1��2 ] [ 1��1��1 ] [ 1��2��2 ]
 * 
 * �������
 * 
 * 3 3 4
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kids = {1,2,2};
		System.out.println(Solution.sendCandy(kids));
	}

	public static int sendCandy(int[] kids) {
		if (kids == null || kids.length == 0) {
			return 0;
		}
		int len = kids.length;
		int[] everyKids = new int[len];
		Arrays.fill(everyKids, 1);
		/**
		 * from left to right
		 */
		for (int i = 0; i < len - 1; ++i) {
			if (kids[i] > kids[i + 1]) {
				everyKids[i] = everyKids[i + 1] + 1;
			}
		}
		/**
		 * from right to left
		 */
		for (int i = len - 1; i >= 1; --i) {
			if (kids[i] > kids[i - 1]) {
				everyKids[i] = Math.max(everyKids[i], everyKids[i - 1] + 1);
			}
		}
		int total = 0;
		for (int num : everyKids) {
			total += num;
		}
		return total;
	}
}
