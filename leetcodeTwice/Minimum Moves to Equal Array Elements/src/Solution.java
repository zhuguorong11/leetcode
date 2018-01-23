/**
 * Given a non-empty integer array of size n, find the minimum number of moves
 * required to make all array elements equal, where a move is incrementing n - 1
 * elements by 1.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 3
 * 
 * Explanation: Only three moves are needed (remember each move increments two
 * elements):
 * 
 * [1,2,3] => [2,3,3] => [3,4,3] => [4,4,4]
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minMoves(int[] nums) {
		// ��Ϊֻ�ܶ�n-1��������1���������ҵ���С������Ȼ��������飬sum(num[i]-min)����
		int min = nums[0];
		int minMoves = 0;
		for (int i = 1; i < nums.length; ++i) {
			min = Math.min(min, nums[i]);
		}
		for (int num : nums) {
			minMoves = minMoves + (num - min);
		}
		return minMoves;
	}
}
