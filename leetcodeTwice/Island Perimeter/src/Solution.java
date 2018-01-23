/**
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water. Grid cells are connected
 * horizontally/vertically (not diagonally). The grid is completely surrounded
 * by water, and there is exactly one island (i.e., one or more connected land
 * cells). The island doesn't have "lakes" (water inside that isn't connected to
 * the water around the island). One cell is a square with side length 1. The
 * grid is rectangular, width and height don't exceed 100. Determine the
 * perimeter of the island.
 * 
 * Example:
 * 
 * [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 * 
 * Answer: 16 Explanation: The perimeter is the 16 yellow stripes in the image
 * below:
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int islandPerimeter(int[][] grid) {
		// notice that when two lands adjacent,the side will be reduced by 2,
		// so we can count how many adjacent lands in grid and total lands
		// finla we use 4 * total - 2 * adjacent
		int row = grid.length;
		if (row == 0)
			return 0;
		int col = grid[0].length;
		int totalLands = 0, adjacents = 0;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				if (grid[i][j] == 1) {
					++totalLands;
					// judge
					if (i < row - 1 && grid[i + 1][j] == 1)
						++adjacents;
					if (j < col - 1 && grid[i][j + 1] == 1)
						++adjacents;
				}
			}
		}
		return 4 * totalLands - 2 * adjacents;
	}
}
