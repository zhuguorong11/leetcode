import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * */
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<>());
		for (int num : nums) {
			List<List<Integer>> temp = new ArrayList<List<Integer>>();// 临时的一个列表
			for (List<Integer> sub : res) {
				List<Integer> subTemp = new ArrayList<>(sub);
				subTemp.add(num);
				temp.add(subTemp);
			}
			res.addAll(temp);
		}
		return res;
	}
}
