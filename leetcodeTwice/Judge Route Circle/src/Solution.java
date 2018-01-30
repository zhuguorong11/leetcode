/**
 * nitially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original
 * place.
 * 
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * 
 * Example 1: Input: "UD" Output: true Example 
 * 		   2: Input: "LL" Output: false
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String moves = "LL";
		System.out.println(Solution.judgeCircle(moves));
	}

	public static boolean judgeCircle(String moves) {
		if (moves == null || moves.length() == 0) {
			return false;
		}
		int vertical = 0;
		int horizontal = 0;
		for (char ch : moves.toCharArray()) {
			switch (ch) {
			case 'R':
				++horizontal;
				break;
			case 'L':
				--horizontal;
				break;
			case 'U':
				++vertical;
				break;
			case 'D':
				--vertical;
				break;
			default:
				break;
			}
		}
		return (vertical == 0 && horizontal == 0) ? true : false;
	}
}
