import java.util.ArrayList;
import java.util.List;

/*
 * Given an array of integers, 1 ¡Ü a[i] ¡Ü n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		if (len <= 1) {
			return res;
		}
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if(nums[index] < 0)
			{
				res.add(index + 1);
			}
			nums[index] = - nums[index];
		}
		return res;
	}
}
