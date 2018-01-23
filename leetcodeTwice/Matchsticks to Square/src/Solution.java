import java.util.Arrays;

/**
 * Remember the story of Little Match Girl? By now, you know exactly what
 * matchsticks the little match girl has, please find out a way you can make one
 * square by using up all those matchsticks. You should not break any stick, but
 * you can link them up, and each matchstick must be used exactly one time.
 * 
 * Your input will be several matchsticks the girl has, represented with their
 * stick length. Your output will either be true or false, to represent whether
 * you could make one square using all the matchsticks the little match girl
 * has.
 * 
 * Example 1: Input: [1,1,2,2,2] Output: true
 * 
 * Explanation: You can form a square with length 2, one side of the square came
 * two sticks with length 1. Example 2: Input: [3,3,3,3,4] Output: false
 * 
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * 
 * @author zhugr
 *
 */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean makesquare(int[] nums) {
		if (nums == null)
			return false;
		if (nums.length <= 3)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 4 != 0)
			return false;
		int target = sum / 4;
		Arrays.sort(nums);
		//after reverse,we can solute the larger num previously
		reverse(nums);
		return dfs(nums, 0, new int[4], target);
	}
	public boolean dfs(int[] nums, int startIndex, int[] sum, int target) {
		if(startIndex == nums.length){
			if (sum[0] == target && sum[1] == target && sum[2] == target)
				return true;
			return false;
		}
		for (int i = 0; i < 4; ++i) {
			// if sum[i] + nums[startIndex] > target,that means this sum[i] may
			// be large, we should use next sum to try
			if (sum[i] + nums[startIndex] > target)
				continue;
			sum[i] += nums[startIndex];
			// recurse next step
			if (dfs(nums, startIndex + 1, sum, target))
				return true;
			// use backtrack
			sum[i] -= nums[startIndex];
		}
		return false;
	}
	public void reverse(int[] nums) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			++i;
			--j;
		}
	}
}
