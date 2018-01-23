import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are n different online courses numbered from 1 to n. Each course has
 * some duration(course length) t and closed on dth day. A course should be
 * taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 * 
 * Given n online courses represented by pairs (t,d), your task is to find the
 * maximal number of courses that can be taken.
 * 
 * Example: Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] Output:
 * 3 Explanation: There're totally 4 courses, but you can take 3 courses at
 * most: First, take the 1st course, it costs 100 days so you will finish it on
 * the 100th day, and ready to take the next course on the 101st day. Second,
 * take the 3rd course, it costs 1000 days so you will finish it on the 1100th
 * day, and ready to take the next course on the 1101st day. Third, take the 2nd
 * course, it costs 200 days so you will finish it on the 1300th day. The 4th
 * course cannot be taken now, since you will finish it on the 3300th day, which
 * exceeds the closed date.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		System.out.println(Solution.scheduleCourse(courses));
	}
	

	public static int scheduleCourse(int[][] courses) {
		Arrays.sort(courses, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];// We have to deal with courses with early deadlines first
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
 				return o2 - o1;//decs by duration
			}
		});
		int time = 0;
		for(int[] course : courses){
			time += course[0];
			queue.add(course[0]);
			if(time > course[1])//exceed dth day
				time -= queue.poll();//remove the most duration time by now
		}
		return queue.size();
	}
}
