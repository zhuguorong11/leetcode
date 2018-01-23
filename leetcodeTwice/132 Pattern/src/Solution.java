/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a
 * subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an
 * algorithm that takes a list of n numbers as input and checks whether there is
 * a 132 pattern in the list.
 * 
 * Note: n will be less than 15,000.
 * 
 * Example 1: Input: [1, 2, 3, 4]
 * 
 * Output: False
 * 
 * Explanation: There is no 132 pattern in the sequence. Example 2: Input: [3,
 * 1, 4, 2]
 * 
 * Output: True
 * 
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2]. Example 3:
 * Input: [-1, 3, 2, 0]
 * 
 * Output: True
 * 
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1,
 * 3, 0] and [-1, 2, 0].
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 1, 4, 2 };
		System.out.println(Solution.find132pattern(nums));
	}

	public static boolean find132pattern(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		int i = 0, j = 0, k = 0;
		int len = nums.length;
		while (i < len) {
			while (i < len - 1 && nums[i] >= nums[i + 1])
				++i;
			j = i + 1;
			while (j < len - 1 && nums[j] <= nums[j + 1])
				++j;
			k = j + 1;
			while (k < len) {
				if (nums[k] > nums[i] && nums[k] < nums[j])
					return true;
				++k;
			}
			i = j + 1;

		}
		return false;
	}
}
