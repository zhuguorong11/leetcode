/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int row;
	int col;
	public int numIslands(char[][] grid) {
		row = grid.length;
		if (row == 0)
			return 0;
		col = grid[0].length;
		// every grid use dfs to find island
		int res = 0;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					++res;
				}
			}
		}
		return res;
	}
	//use dfs,we should change the visited grid to avoid duplicate visit
	public void dfs(char[][] grid, int i, int j) {
		// when grid[i][j] == '1' ,means adjacent grid both are 1
		if (i >= row || i < 0 || j >= col || j < 0 || grid[i][j] != '1')
			return;
		grid[i][j] = '#';// to avoid duplicate visit
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
	}
}
