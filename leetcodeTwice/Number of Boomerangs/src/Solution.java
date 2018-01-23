import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is
 * a tuple of points (i, j, k) such that the distance between i and j equals the
 * distance between i and k (the order of the tuple matters).
 * 
 * Find the number of boomerangs. You may assume that n will be at most 500 and
 * coordinates of points are all in the range [-10000, 10000] (inclusive).
 * 
 * Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfBoomerangs(int[][] points) {
		int pointsNum = points.length;
		if (pointsNum == 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int res = 0;
		// firs loop as the i of tuple(i,j,k)
		for (int i = 0; i < pointsNum; ++i) {
			for (int j = 0; j < pointsNum; ++j) {
				int dis = distanceGet(points[i], points[j]);
				map.put(dis, map.getOrDefault(dis, 0) + 1);
			}
			// finis the i point,we should get the result of this situation
			// if there are k points which are away from i point is dif,that we
			// can select k * ( k - 1) situations
			for (int value : map.values())
				res += value * (value - 1);
			// finally,we should clear the map to next i point use
			map.clear();
		}
		return res;
	}

	public int distanceGet(int[] p, int[] q) {
		int x = p[0] - q[0];
		int y = p[1] - q[1];
		return x * x + y * y;
	}
}
