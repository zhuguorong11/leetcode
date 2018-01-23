import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to
 * make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minMoves2(int[] nums) {
		int minMoves = 0;
		Arrays.sort(nums);
		int len = nums.length;
		int mid = nums[len / 2];
		for(int num : nums){
			minMoves += Math.abs(num - mid);
		}
		return minMoves;
	}
}
