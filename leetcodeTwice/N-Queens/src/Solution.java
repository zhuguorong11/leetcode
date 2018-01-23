import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * For example, There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [ [".Q..", // Solution 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(n <= 0)
			return res;
		helper(n, 0, res, new ArrayList<>(), new boolean[n], new boolean[2 * n], new boolean[2 * n]);
		return res;
	}
	/**
	 * 
	 * @param n size
	 * @param row  current row index
	 * @param res 
	 * @param curRow current row set
	 * @param cols judge whether there has queue at this column
	 * @param dl1 judge whether there has queue at this diagonals 1
	 * @param dl2 judge whether there has queue at this diagonals 2
	 */
	public void helper(int n, int row , List<List<String>> res, List<String> curRow,boolean[] cols,boolean[] diagonals1,boolean[] diagonals2){
		if(row == n)
		{
			res.add(new ArrayList<>(curRow));
			return ;
		}
		for(int col = 0; col < n; ++col){
			/*
			 *For Example , we have the given 2D board:
			(0,0) (0,1) (0,2) (0,3)
			(1,0) (1,1) (1,2) (1,3)
			(2,0) (2,1) (2,2) (2,3)
			(3,0) (3,1) (3,2) (3,3)
			where the (x,y) represents the position in the board.
			Now lets just take a point (1,2). Now the two diagonals that pass through it are :

			1��Through the points (0,1) (1,2) (2,3). These points are considered for d1 boolean array. 
			If we look at any point in this set, x-y is the same. 
			0-1 == 1-2 == 2-3. Hence i-j + board.length will give the same index in d1 for all its diagonal elements,since i-j will be the same.
			
			2��Through the points (0,3) (1,2) (2,1) (3,0) . These points are considered for the d2 boolean array. 
			Now if you look at the points , the sum of x and y coordinates is the same for all points. 
			Hence 2board.length -i-j-1 == 2board.length -(i+j) -1 which will be the same for all the points in the diagonal. 
			Hence if the idx in d2 is true already , that would mean some point in the diagonal already had a queen. 
			 */
			int dl1 = row - col + n;
			int dl2 = 2 * n - (row + col) - 1;
			if(!cols[col] && !diagonals1[dl1] && !diagonals2[dl2])
			{
				cols[col] = true;
				diagonals1[dl1] = true;
				diagonals2[dl2] = true;
				char[] chs = new char[n];
				Arrays.fill(chs, '.');
				chs[col] = 'Q';
				curRow.add(new String(chs));
				helper(n, row + 1, res, curRow, cols, diagonals1, diagonals2);
				//backtracking
				cols[col] = false;
				diagonals1[dl1] = false;
				diagonals2[dl2] = false;
				curRow.remove(curRow.size() - 1);
			}
		}
	}
}
