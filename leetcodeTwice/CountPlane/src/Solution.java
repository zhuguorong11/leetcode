import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 给出飞机的起飞和降落时间的列表，用 interval 序列表示. 请计算出天上同时最多有多少架飞机？
 * 
 * 样例 对于每架飞机的起降时间列表：[[1,10],[2,3],[5,8],[4,7]], 返回3。
 * 
 * 注意 如果多架飞机降落和起飞在同一时刻，我们认为降落有优先权。
 * 
 * @author zhugr
 *
 */
public class Solution {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> list = new ArrayList<>();
		list.add(new Interval(1, 10));
		list.add(new Interval(2, 3));
		list.add(new Interval(5, 8));
		list.add(new Interval(4, 7));
		System.out.println(Solution.countOfAirplanes(list));
	}

	public static int countOfAirplanes(List<Interval> airplanes) {
		int lastTime = Integer.MIN_VALUE;
		for (int i = 0; i < airplanes.size(); ++i) {
			lastTime = Math.max(lastTime, airplanes.get(i).end);
		}
		int[] count = new int[lastTime + 1];
		for (int i = 0; i < airplanes.size(); ++i) {
			Interval cur = airplanes.get(i);
			/* fly */
			++count[cur.start];
			/* land */
			--count[cur.end];
		}
		int res = 0;
		int temp = 0;
		for (int i = 0; i <= lastTime; ++i) {
			temp += count[i];
			res = Math.max(temp, res);
		}
		return res;
	}
}

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

}