/**
 * The demons had captured the princess (P) and imprisoned her in the
 * bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid
 * out in a 2D grid. Our valiant knight (K) was initially positioned in the
 * top-left room and must fight his way through the dungeon to rescue the
 * princess.
 * 
 * The knight has an initial health point represented by a positive integer. If
 * at any point his health point drops to 0 or below, he dies immediately.
 * 
 * Some of the rooms are guarded by demons, so the knight loses health (negative
 * integers) upon entering these rooms; other rooms are either empty (0's) or
 * contain magic orbs that increase the knight's health (positive integers).
 * 
 * In order to reach the princess as quickly as possible, the knight decides to
 * move only rightward or downward in each step.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int calculateMinimumHP(int[][] dungeon) {
		if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
			return 0;
		}
		int row = dungeon.length;
		int col = dungeon[0].length;
		int[][] dp = new int[row + 1][col + 1];
		/* 走到最后一格的时候必须要至少有一滴血 */
		dp[row][col - 1] = 1;
		dp[row - 1][col] = 1;

		for (int i = row - 1; i >= 0; --i) {
			for (int j = col - 1; j >= 0; --j) {
				if (i == row - 1 && j == col - 1) {
					dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
				} else if (i == row - 1) {
					dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
				} else if (j == col - 1) {
					dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
				} else {
					int shouldNeed = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
					dp[i][j] = shouldNeed <= 0 ? 1 : shouldNeed;
				}
			}
		}
		return dp[0][0];
	}
}
