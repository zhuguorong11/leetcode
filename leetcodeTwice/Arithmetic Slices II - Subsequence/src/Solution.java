import java.util.HashMap;
import java.util.Map;

/**
 * Example:
 * 
 * Input: [2, 4, 6, 8, 10]
 * 
 * Output: 7
 * 
 * Explanation: All arithmetic subsequence slices are: [2,4,6] [4,6,8] [6,8,10]
 * [2,4,6,8] [4,6,8,10] [2,4,6,8,10] [2,6,10]
 * 
 * 不一定是要连续的
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int len = A.length;
		@SuppressWarnings("unchecked")
		Map<Integer, Integer>[] maps = new HashMap[len];
		int resCount = 0;
		for (int i = 0; i < len; ++i) {
			maps[i] = new HashMap<>();
			int num = A[i];
			for (int j = 0; j < i; ++j) {
				// he output is guaranteed to be less than 2^31 -1
				if ((long) num - A[j] > Integer.MAX_VALUE) {
					continue;
				}
				// he output is guaranteed to be more than 2^31 -1
				if ((long) num - A[j] < Integer.MIN_VALUE) {
					continue;
				}

				int diff = num - A[j];
				int count = maps[j].getOrDefault(diff, 0);
				resCount += count;
				maps[i].put(diff, maps[i].getOrDefault(diff, 0) + count + 1);
			}
		}
		return resCount;
	}
}
