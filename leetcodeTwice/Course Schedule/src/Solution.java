import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		//use graph and indegree
		//int[][] courseGraph = new int[numCourses][numCourses];//record the conncet between course
		int[] indegree = new int[numCourses];//record every course's indegree
		for(int i = 0; i < prerequisites.length; ++i){
			//int preCourse = prerequisites[i][1];
			int nowCourse = prerequisites[i][0];
			++indegree[nowCourse]; //no duplicate input
		}
		//the we use a queue to store course whose indegree is zero
		Queue<Integer> zeroIndegree = new LinkedList<>();
		int count = 0;//record the number of course whose indegree is zero
		for(int i = 0; i < numCourses; ++i){
			if(indegree[i] == 0)
			{
				zeroIndegree.add(i);
				++count;
			}
		}
		while(!zeroIndegree.isEmpty()){
			int curCourse = zeroIndegree.poll();
			for(int i = 0; i < numCourses; ++i){//iterate every pair of this curCourse
				if(prerequisites[i][1] == curCourse)
				{
					--indegree[i];//remove this line 
					if(indegree[i] == 0)
					{
						zeroIndegree.add(i);
						++count;
					}
				}
			}
		}
		//whether the number of course whose indegree is zero equals numCourses
		//that means that all course can not form a circle
		return count == numCourses;
	}
	
	//easy union find
	public boolean canFinish2(int numCourses, int[][] prerequisites){
		if (numCourses < 1 || prerequisites == null || prerequisites.length < 1) {
            return true;
        }
        int[] preRequire = new int[numCourses];
        //initial
        for (int i = 0; i < numCourses; i++) {
        	preRequire[i] = i;
        }
        for(int i = 0; i < prerequisites.length; ++i){
        	int preCourse = prerequisites[i][1];
			int nowCourse = prerequisites[i][0];
			preRequire[nowCourse] = preCourse;
			while(preCourse != preRequire[preCourse]){//not self, if is self,skip
				preCourse = preRequire[preCourse];//是有有之前的课程的前提课程是nouCourese
				if(nowCourse == preCourse){//form a circle means false
					return false;
				}
			}
        }
        return true;
	}
}
