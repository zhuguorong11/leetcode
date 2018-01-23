import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals.size() <= 1)
			return intervals;
		// 对start进行排序
		intervals.sort(new Comparator<Interval>() {
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		List<Interval> res = new ArrayList<>();
		Interval first = intervals.get(0);
		int start = first.start;
		int end = first.end;
		for (Interval interval : intervals) {
			if (interval.start <= end) {
				end = Math.max(interval.end, end);
			} else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		//加入最后一个，因为上面循环只判断到最后一个interval，但是并未加入到res中
		res.add(new Interval(start, end));
		return res;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}