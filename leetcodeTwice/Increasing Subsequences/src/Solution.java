import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an integer array, your task is to find all the different possible
 * increasing subsequences of the given array, and the length of an increasing
 * subsequence should be at least 2 .
 * 
 * Example: Input: [4, 6, 7, 7] Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7,
 * 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 
 * @author zhugr
 *
 */
public class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		//因为每一个List<Integer>不能重复，所以使用set
		Set<List<Integer>> res = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		helper(res, list, nums, 0);
		return new ArrayList<>(res);
	}

	public void helper(Set<List<Integer>> res, List<Integer> curList, int[] nums, int startIndex) {
		// lenght of the curList more or equal 2, we should add into res\
		if (curList.size() >= 2) {
			res.add(new ArrayList<>(curList));
		}
		for (int i = startIndex; i < nums.length; ++i) {
			// if i == 0 or the last number of curList <= nums[i],add this num
			// into curList
			// then we recurve this function
			// last we should backtrack
			if (curList.size() == 0 || curList.get(curList.size() - 1) <= nums[i])
			{
				curList.add(nums[i]);
				helper(res, curList, nums, i + 1);
				curList.remove(curList.size() - 1);
			}
		}
	}
}
