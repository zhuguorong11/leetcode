import java.util.ArrayList;
import java.util.List;

/*
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers 
 * from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		helper(res, new ArrayList<>(), n, k, 1);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> temp, int target, int k, int start) {
		if (temp.size() == k && target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i <= 9; i++) {
			if (i <= target) {
				temp.add(i);
				helper(res, temp, target - i, k, i + 1);
				// »ØËÝ·¨
				temp.remove(temp.size() - 1);
			}
		}
	}
}
