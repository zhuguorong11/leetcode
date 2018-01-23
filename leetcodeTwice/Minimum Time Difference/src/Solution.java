import java.util.List;

/**
 * Given a list of 24-hour clock time points in "Hour:Minutes" format, find the
 * minimum minutes difference between any two time points in the list.
 * 
 * Example 1: Input: ["23:59","00:00"] Output: 1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMinDifference(List<String> timePoints) {
		int size = timePoints.size();
		// ����һ��Ͱ�����60*24�Ŀ���
		boolean[] time = new boolean[60 * 24];
		for (int i = 0; i < size; ++i) {
			String[] hm = timePoints.get(i).split(":");
			int hours = Integer.parseInt(hm[0]);
			int minutes = Integer.parseInt(hm[1]);
			if (time[hours * 60 + minutes])
				return 0;// ˵������ʱ����һ����
			else
				time[hours * 60 + minutes] = true;
		}
		int min = Integer.MAX_VALUE;// ʱ�� ��Ϊ����"23:59","00:00"�����������Ҫ���бȽ�
		int minTime = Integer.MAX_VALUE;// �����С��ʱ��
		int maxTime = Integer.MIN_VALUE;// ����ϴ�ʱ��
		int pre = -1;// �����ǰһ��ʱ��
		for (int i = 0; i < 60 * 24; ++i) {
			if (time[i]) {// list�е�ʱ��
				if (minTime != Integer.MAX_VALUE) {// ˵����С���Ѿ����ֹ���
					min = Math.min(min, i - pre);
				}
				minTime = Math.min(minTime, i);
				maxTime = Math.max(maxTime, i);
				pre = i;
			}
		}
		min = Math.min(min, 60 * 24 - maxTime + minTime);// ��Ϊ����"23:59","00:00"�����������Ҫ���бȽ�
		return min;
	}
}
