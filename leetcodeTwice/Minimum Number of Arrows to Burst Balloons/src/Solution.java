import java.util.Arrays;
import java.util.Comparator;

/**
 * There are a number of spherical balloons spread in two-dimensional space. For
 * each balloon, provided input is the start and end coordinates of the
 * horizontal diameter. Since it's horizontal, y-coordinates don't matter and
 * hence the x-coordinates of start and end of the diameter suffice. Start is
 * always smaller than end. There will be at most 104 balloons.
 * 
 * An arrow can be shot up exactly vertically from different points along the
 * x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart
 * °‹ x °‹ xend. There is no limit to the number of arrows that can be shot. An
 * arrow once shot keeps travelling up infinitely. The problem is to find the
 * minimum number of arrows that must be shot to burst all balloons.
 * 
 * Example:
 * 
 * Input: [[10,16], [2,8], [1,6], [7,12]]
 * 
 * Output: 2
 * 
 * Explanation: One way is to shoot one arrow for example at x = 6 (bursting the
 * balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two
 * balloons).
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// classical greedy
	public int findMinArrowShots(int[][] points) {
		int balloonNums = points.length;
		if (balloonNums == 0)
			return 0;
		// ∞¥’’startΩ¯––≈≈–Ú
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				else
					return o1[0] - o2[0];
			}
		});
		int res = 1;
		int end = points[0][1];
		for (int i = 1; i < balloonNums; ++i) {
			if (end < points[i][0]) {
				++res;
				end = points[i][1];
			} else
				end = Math.min(end, points[i][1]);
		}
		return res;
	}
}
