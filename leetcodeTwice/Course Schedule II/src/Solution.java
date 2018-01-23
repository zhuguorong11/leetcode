import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		int[] resOrder = new int[numCourses];
		int count = 0;
		for (int i = 0; i < prerequisites.length; ++i) {
			int now = prerequisites[i][0];
			indegree[now]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; ++i) {
			if (indegree[i] == 0)// 当没有前序课程需要学时
			{
				resOrder[count++] = i;// 将课程号加入到结果集中，并压入队列中
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int preCourse = queue.poll();
			for (int i = 0; i < prerequisites.length; ++i) {
				if (prerequisites[i][1] == preCourse)// 如果prerequisites[i][1]课程的前序课程为preCourse，则该prerequisites课程入度-1
				{
					indegree[prerequisites[i][0]]--;
					if (indegree[prerequisites[i][0]] == 0)// 当该prerequisites[i][0]课程的入度也为0，表示可以修该课程了，再压入队列，作为其他课程的前序
					{
						queue.add(prerequisites[i][0]);
						resOrder[count++] = prerequisites[i][0];
					}
				}
			}
		}
		return count == numCourses ? resOrder : new int[0];
	}
}
