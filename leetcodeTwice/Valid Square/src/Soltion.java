/**
 * Given the coordinates of four points in 2D space, return whether the four
 * points could construct a square.
 * 
 * The coordinate (x,y) of a point is represented by an integer array with two
 * integers.
 * 
 * Example: Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1] Output: True
 * 
 * @author zhugr
 *
 */
public class Soltion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		// 通过4个点得到6个距离
		long[] distances = { getDistance(p1, p2), getDistance(p1, p3), getDistance(p1, p4), getDistance(p2, p3),
				getDistance(p2, p4), getDistance(p3, p4) };
		// 正方形两对象线最长，且相等
		long maxEdge = 0;
		int maxCount = 0;
		long notMaxEdge = 0;
		for (long dis : distances)
			maxEdge = Math.max(maxEdge, dis);
		for (long dis : distances) {
			if (dis == maxEdge)
				++maxCount;
			else
				notMaxEdge = dis;
		}
		if (maxCount != 2) {
			return false;
		}
		for (long dis : distances) {
			if (dis != maxEdge && dis != notMaxEdge)
				return false;
		}
		return true;
	}

	public long getDistance(int[] p1, int[] p2) {
		return (long) Math.pow((p1[0] - p2[0]), 2) + (long) Math.pow((p1[1] - p2[1]), 2);
	}
}
