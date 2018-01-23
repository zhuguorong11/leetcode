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
		// 利用一个桶来存放60*24的可能
		boolean[] time = new boolean[60 * 24];
		for (int i = 0; i < size; ++i) {
			String[] hm = timePoints.get(i).split(":");
			int hours = Integer.parseInt(hm[0]);
			int minutes = Integer.parseInt(hm[1]);
			if (time[hours * 60 + minutes])
				return 0;// 说明两个时间是一样的
			else
				time[hours * 60 + minutes] = true;
		}
		int min = Integer.MAX_VALUE;// 时间差、 因为存在"23:59","00:00"的情况，所以要进行比较
		int minTime = Integer.MAX_VALUE;// 保存较小的时间
		int maxTime = Integer.MIN_VALUE;// 保存较大时间
		int pre = -1;// 保存较前一个时间
		for (int i = 0; i < 60 * 24; ++i) {
			if (time[i]) {// list中的时间
				if (minTime != Integer.MAX_VALUE) {// 说明较小的已经出现过了
					min = Math.min(min, i - pre);
				}
				minTime = Math.min(minTime, i);
				maxTime = Math.max(maxTime, i);
				pre = i;
			}
		}
		min = Math.min(min, 60 * 24 - maxTime + minTime);// 因为存在"23:59","00:00"的情况，所以要进行比较
		return min;
	}
}
