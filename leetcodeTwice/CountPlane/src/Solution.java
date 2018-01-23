import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �����ɻ�����ɺͽ���ʱ����б��� interval ���б�ʾ. ����������ͬʱ����ж��ټܷɻ���
 * 
 * ���� ����ÿ�ܷɻ�����ʱ���б�[[1,10],[2,3],[5,8],[4,7]], ����3��
 * 
 * ע�� �����ܷɻ�����������ͬһʱ�̣�������Ϊ����������Ȩ��
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