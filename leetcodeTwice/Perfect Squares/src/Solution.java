import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSquares(int n) {

		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			dp[i] = i;// 任何一个数都可以n个1相加
			for (int j = 1; j * j <= i; ++j) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
		return dp[n];
	}

	// 用bfs的方法
	public int bfs(int n) {
		if (n <= 0) {
			return 0;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		int res = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; ++i) {
				int curNum = queue.poll();
				int intNum = (int) Math.sqrt(curNum);
				if (intNum * intNum == curNum) {
					return res;
				}
				for (int j = intNum; j > 0; --j) {
					queue.offer(curNum - j * j);
				}
			}
			++res;//加数的个数多一个
		}
		return res;

	}
}
