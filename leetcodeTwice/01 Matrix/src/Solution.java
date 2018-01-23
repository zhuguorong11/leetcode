import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1. 
 *Example 1: 
Input:

0 0 0
0 1 0
0 0 0
Output:
0 0 0
0 1 0
0 0 0
Example 2: 
Input:

0 0 0
0 1 0
1 1 1
Output:
0 0 0
0 1 0
1 2 1
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] updateMatrix(int[][] matrix) {
		// now we use bfs
		Queue<int[]> queue = new LinkedList<>();
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				// put index of i,j whose value equals zero
				if (matrix[i][j] == 0)
					queue.add(new int[] { i, j });
				else
					// we set other cell's value as inf
					matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		// we define all directions
		int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!queue.isEmpty()) {
			int[] cell = queue.poll();
			for (int[] dir : dirs) {// check all dirs
				int nowRow = cell[0] + dir[0]; 
				int nowCol = cell[1] + dir[1];
				if (nowRow < 0 || nowRow >= row || nowCol < 0 || nowCol >= col
						|| matrix[nowRow][nowCol] <= matrix[cell[0]][cell[1]] + 1)
					continue;
				// otherwise,we shoud put nowRow and nowCol into queue
				queue.add(new int[] { nowRow, nowCol });
				matrix[nowRow][nowCol] = matrix[cell[0]][cell[1]] + 1;// update
			}
		}
		return matrix;
	}
}
