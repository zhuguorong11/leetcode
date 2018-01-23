import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations 
 * in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]

 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//每个数能重复使用，而且数组中没有重复的值
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				temp.add(candidates[i]);
				helper(res, temp, candidates, target - candidates[i], i);// 因为同一数组中可以使用多次，所以还是从i开始
				// 回溯法
				temp.remove(temp.size() - 1);
			}
		}
	}
}
