import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in
 * ascending order, find the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example:
 * 
 * matrix = [ [ 1, 5, 9], [10, 11, 13], [12, 13, 15] ], k = 8,
 * 
 * return 13.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int kthSmallest(int[][] matrix, int k) {
		// use heap
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
			}
		});
		int row = matrix.length;
		// add first row to heap
		for (int i = 0; i < row; ++i)
			queue.offer(new int[] { 0, i });
		for (int i = 0; i < k - 1; ++i) {
			int[] cur = queue.poll();
			// cur is the last row num
			if (cur[0] == row - 1)
				continue;
			// add the the same column of next row number
			queue.offer(new int[] { cur[0] + 1, cur[1] });
		}
		int[] res = queue.poll();
		return matrix[res[0]][res[1]];
	}
}
